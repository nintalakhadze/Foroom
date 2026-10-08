
package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.ConversationSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.utils.Constants.ADDITIONAL_MESSAGE_COUNT
import com.example.foroom.utils.Constants.ADDITIONAL_MESSAGE_PREFIX
import com.example.foroom.utils.Constants.GREETING_PREFIX
import com.example.foroom.utils.Constants.JOHN_WEEK_CHAT
import com.example.foroom.utils.Constants.MESSAGE_FOR_JOHN
import com.example.foroom.utils.Constants.MY_CHAT
import com.example.foroom.utils.Constants.QUESTION
import com.example.foroom.utils.Constants.REPLY_PREFIX
import com.example.foroom.utils.Constants.SHARED_CHAT
import com.example.foroom.utils.Constants.USER_A_PASSWORD
import com.example.foroom.utils.Constants.USER_A_USERNAME
import com.example.foroom.utils.Constants.USER_B_PASSWORD
import com.example.foroom.utils.Constants.USER_B_USERNAME
import org.junit.Rule
import org.junit.Test

class ChatTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java)

    private val loginSteps = LoginSteps()
    private val chatSteps = ChatSteps()
    private val conversationSteps = ConversationSteps()

    @Test
    fun sendMessageAndVerifyAfterReopening() {
        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(USER_A_USERNAME, USER_A_PASSWORD)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.scrollToChat(JOHN_WEEK_CHAT)
        chatSteps.openChat(JOHN_WEEK_CHAT)

        conversationSteps.verifyConversationOpened(JOHN_WEEK_CHAT)

        conversationSteps.sendMessage(MESSAGE_FOR_JOHN)
        conversationSteps.verifyMessageDisplayed(MESSAGE_FOR_JOHN)

        conversationSteps.closeConversation()

        chatSteps.scrollToChat(JOHN_WEEK_CHAT)
        chatSteps.openChat(JOHN_WEEK_CHAT)

        conversationSteps.verifyConversationOpened(JOHN_WEEK_CHAT)
        conversationSteps.verifyMessageDisplayed(MESSAGE_FOR_JOHN)
    }

    @Test
    fun sendAutomationAcademyQuestion() {
        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(USER_A_USERNAME, USER_A_PASSWORD)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.scrollToChat(MY_CHAT)
        chatSteps.openChat(MY_CHAT)

        conversationSteps.verifyConversationOpened(MY_CHAT)

        conversationSteps.sendMessage(QUESTION)
        conversationSteps.verifyMessageDisplayed(QUESTION)
    }

    @Test
    fun exchangeMessagesBetweenUsersInSharedChat() {
        val timestamp = System.currentTimeMillis()

        val greeting = "$GREETING_PREFIX $timestamp"
        val reply = "$REPLY_PREFIX $timestamp"

        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(USER_A_USERNAME, USER_A_PASSWORD)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.scrollToChat(SHARED_CHAT)
        chatSteps.openChat(SHARED_CHAT)

        conversationSteps.verifyConversationOpened(SHARED_CHAT)

        conversationSteps.sendMessage(greeting)
        conversationSteps.verifyMessageDisplayed(greeting)

        repeat(ADDITIONAL_MESSAGE_COUNT) { index ->
            val message = "$ADDITIONAL_MESSAGE_PREFIX ${index + 1} $timestamp"

            conversationSteps.sendMessage(message)
            conversationSteps.verifyMessageDisplayed(message)
        }

        conversationSteps.closeConversation()

        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(USER_B_USERNAME, USER_B_PASSWORD)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.scrollToChat(SHARED_CHAT)
        chatSteps.openChat(SHARED_CHAT)

        conversationSteps.verifyConversationOpened(SHARED_CHAT)

        conversationSteps.findOlderMessage(greeting)
        conversationSteps.verifyMessageWithSender(
            greeting,
            USER_A_USERNAME
        )

        conversationSteps.sendMessage(reply)
        conversationSteps.verifyMessageWithSender(
            reply,
            USER_B_USERNAME
        )

        conversationSteps.closeConversation()

        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(USER_A_USERNAME, USER_A_PASSWORD)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.scrollToChat(SHARED_CHAT)
        chatSteps.openChat(SHARED_CHAT)

        conversationSteps.verifyConversationOpened(SHARED_CHAT)

        conversationSteps.verifyMessageWithSender(
            reply,
            USER_B_USERNAME
        )
    }
}
