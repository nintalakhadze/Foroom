package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.foroom.pages.ChangeLanguagePage
import com.example.foroom.pages.ChangePasswordPage
import com.example.foroom.pages.ProfilePage

class ProfileSteps {

    private val profilePage = ProfilePage()
    private val changePasswordPage = ChangePasswordPage()
    private val changeLanguagePage = ChangeLanguagePage()

    fun openProfile() {
        profilePage.clickProfileBtn()
    }

    fun openChangePassword() {
        profilePage.clickChangePassword()
    }

    fun changePassword(newPassword: String) {
        changePasswordPage.enterPassword(newPassword)
        changePasswordPage.enterRepeatPassword(newPassword)
        changePasswordPage.clickConfirmButton()
    }

    fun openChangeLanguage() {
        profilePage.clickChangeLanguage()
    }

    fun selectGeorgianLanguage() {
        changeLanguagePage.selectGeorgianLanguage()
    }

    fun selectEnglishLanguage() {
        changeLanguagePage.selectEnglishLanguage()
    }

    fun verifyGeorgianProfileDisplayed() {
        onView(withText("ენის შეცვლა"))
            .check(matches(isDisplayed()))
    }

    fun verifyEnglishProfileDisplayed() {
        onView(withText("Change Language"))
            .check(matches(isDisplayed()))
    }
}