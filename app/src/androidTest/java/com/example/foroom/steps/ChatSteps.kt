package com.example.foroom.steps

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.pages.ChatsPage

class ChatSteps {

    private val chatsPage = ChatsPage()

    fun searchChat(chatName: String): ChatSteps {
        onView(chatsPage.searchChatInput)
            .perform(replaceText(chatName))
        return this
    }

    fun verifyChatDisplayedInList(chatName: String): ChatSteps {
        onView(chatsPage.chatTitle(chatName))
            .check(matches(isDisplayed()))
        return this
    }

    fun openChat(chatName: String): ChatSteps {
        onView(chatsPage.openChatButton(chatName))
            .perform(click())
        return this
    }

    fun scrollToChat(chatName: String): ChatSteps {
        onView(chatsPage.chatsRecyclerView)
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    chatsPage.chatItem(chatName)
                )
            )
        return this
    }
}