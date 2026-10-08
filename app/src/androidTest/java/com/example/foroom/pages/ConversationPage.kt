package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class ConversationPage {

    val messagesRecyclerView = withId(R.id.messagesRecyclerView)

    val chatName = withId(com.example.design_system.R.id.chatNameTextView)

    val messageInput = withId(com.example.design_system.R.id.inputEditText)

    val sendMessageButton = withId(R.id.sendMessageButton)

    val closeButton = withId(R.id.closeButton)

    fun conversationTitle(chatName: String): Matcher<View> {
        return allOf(
            this.chatName,
            withText(chatName)
        )
    }

    fun message(message: String): Matcher<View> {
        return allOf(
            withId(com.example.design_system.R.id.messageTextView),
            withText(message),
            isDescendantOfA(messagesRecyclerView)
        )
    }

    fun messageWithSender(message: String, sender: String): Matcher<View> {
        return allOf(
            withId(R.id.messageView),
            isDescendantOfA(messagesRecyclerView),
            hasDescendant(
                allOf(
                    withId(com.example.design_system.R.id.messageTextView),
                    withText(message)
                )
            ),
            hasDescendant(
                allOf(
                    withId(R.id.userNameTextView),
                    withText(sender)
                )
            )
        )
    }
}