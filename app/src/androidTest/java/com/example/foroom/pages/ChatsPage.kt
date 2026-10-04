package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.Helper.first
import org.hamcrest.Matchers.allOf

class ChatsPage {

    val searchChatInput = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.searchChatInput))
    )

    val chatsRecyclerView = withId(R.id.chatsRecyclerView)

    fun searchChat(chatName: String) {
        onView(searchChatInput)
            .perform(replaceText(chatName))
    }

    fun verifyChatDisplayed(chatName: String) {
        onView(
            first(
                allOf(
                    withId(com.example.design_system.R.id.chatTitleTextView),
                    withText(chatName),
                    isDescendantOfA(chatsRecyclerView)
                )
            )
        ).check(matches(isDisplayed()))
    }
}