package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import org.junit.Rule
import org.junit.Test

class ProfileAndChatTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java)

    private val loginSteps = LoginSteps()
    private val profileSteps = ProfileSteps()
    private val chatSteps = ChatSteps()

    private val username = "ninaa"
    private val currentPassword = "ninaa123"
    private val newPassword = "aaa123"

    @Test
    fun createChatAndFindItInChatList() {
        val chatName = "Nino Talakhadze ${System.currentTimeMillis()}"

        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(username, currentPassword)
        loginSteps.verifyHomeScreenDisplayed()

        chatSteps.openCreateChat()
        chatSteps.enterChatName(chatName)
        chatSteps.openChatImageChooser()
        chatSteps.selectChatImage(0)
        chatSteps.createChat()

        chatSteps.verifyCreatedChatOpened(chatName)

        chatSteps.closeChat()
        chatSteps.searchChat(chatName)
        chatSteps.verifyChatDisplayedInList(chatName)
    }

    @Test
    fun changeLanguageFromGeorgianToEnglishAndBack() {
        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(username, currentPassword)
        loginSteps.verifyHomeScreenDisplayed()

        profileSteps.openProfile()

        profileSteps.openChangeLanguage()
        profileSteps.selectGeorgianLanguage()
        profileSteps.verifyGeorgianProfileDisplayed()

        profileSteps.openChangeLanguage()
        profileSteps.selectEnglishLanguage()
        profileSteps.verifyEnglishProfileDisplayed()

        profileSteps.openChangeLanguage()
        profileSteps.selectGeorgianLanguage()
        profileSteps.verifyGeorgianProfileDisplayed()
    }

    @Test
    fun changePasswordAndVerifyLogin() {
        loginSteps.ensureLoginScreenDisplayed()

        loginSteps.login(username, currentPassword)
        loginSteps.verifyHomeScreenDisplayed()

        profileSteps.openProfile()
        profileSteps.openChangePassword()
        profileSteps.changePassword(newPassword)

        loginSteps.verifyLoginScreenDisplayed()

        loginSteps.login(username, newPassword)
        loginSteps.verifyHomeScreenDisplayed()

        //ძველ პაროლს ვაბრუნებ
        profileSteps.openProfile()
        profileSteps.openChangePassword()
        profileSteps.changePassword(currentPassword)
        loginSteps.verifyLoginScreenDisplayed()
    }
}