package com.example.foroom.steps

import android.content.res.Resources
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.swiper
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.pages.ConversationPage

class ConversationSteps {

    private val conversationPage = ConversationPage()

    fun verifyConversationOpened(chatName: String): ConversationSteps {
        onView(conversationPage.conversationTitle(chatName))
            .check(matches(isDisplayed()))
        return this
    }

    fun enterMessage(message: String): ConversationSteps {
        onView(conversationPage.messageInput)
            .perform(replaceText(message))
        return this
    }

    fun clickSendMessage(): ConversationSteps {
        onView(conversationPage.sendMessageButton)
            .perform(click())
        return this
    }

    fun sendMessage(message: String): ConversationSteps {
        return enterMessage(message)
            .clickSendMessage()
    }

    fun verifyMessageDisplayed(message: String): ConversationSteps {
        onView(conversationPage.message(message))
            .waitUntilVisible(5)

        onView(conversationPage.message(message))
            .check(matches(isDisplayed()))
        return this
    }

    fun verifyMessageWithSender(
        message: String,
        sender: String
    ): ConversationSteps {
        onView(conversationPage.messageWithSender(message, sender))
            .waitUntilVisible(10)

        return this
    }
    fun closeConversation(): ConversationSteps {
        onView(conversationPage.closeButton)
            .perform(click())
        return this
    }

    fun findOlderMessage(
        message: String,
        maxAttempts: Int = 10
    ): ConversationSteps {
        val screenHeight = Resources.getSystem().displayMetrics.heightPixels

        val startY = (screenHeight * 0.15).toInt()
        val endY = (screenHeight * 0.85).toInt()

        repeat(maxAttempts) {
            if (isMessageDisplayed(message)) {
                return this
            }

            swiper(
                start = startY,
                end = endY,
                delay = 500
            )
        }

        onView(conversationPage.message(message))
            .check(matches(isDisplayed()))

        return this
    }

    private fun isMessageDisplayed(message: String): Boolean {
        return try {
            onView(conversationPage.message(message))
                .check(matches(isDisplayed()))
            true
        } catch (_: NoMatchingViewException) {
            false
        } catch (_: AssertionError) {
            false
        }
    }
}