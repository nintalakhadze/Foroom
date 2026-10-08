package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.Helper.first
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class ChatsPage {

    val searchChatInput = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.searchChatInput))
    )

    val chatsRecyclerView = withId(R.id.chatsRecyclerView)

    fun chatTitle(chatName: String): Matcher<View> {
        return first(
            allOf(
                withId(com.example.design_system.R.id.chatTitleTextView),
                withText(chatName),
                isDescendantOfA(chatsRecyclerView)
            )
        )
    }

    fun chatItem(chatName: String): Matcher<View> {
        return hasDescendant(
            allOf(
                withId(com.example.design_system.R.id.chatTitleTextView),
                withText(chatName)
            )
        )
    }

    fun openChatButton(chatName: String): Matcher<View> {
        return first(
            allOf(
                withId(R.id.sendMessageButton),
                hasSibling(
                    allOf(
                        withId(com.example.design_system.R.id.chatTitleTextView),
                        withText(chatName)
                    )
                )
            )
        )
    }
}