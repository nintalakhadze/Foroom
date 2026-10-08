package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
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

    fun openProfile(): ProfileSteps {
        onView(profilePage.profileButton)
            .perform(click())
        return this
    }

    fun openChangePassword(): ProfileSteps {
        onView(profilePage.changePasswordItem)
            .perform(click())
        return this
    }

    fun changePassword(newPassword: String): ProfileSteps {
        changePasswordPage.enterPassword(newPassword)
        changePasswordPage.enterRepeatPassword(newPassword)
        changePasswordPage.clickConfirmButton()
        return this
    }

    fun openChangeLanguage(): ProfileSteps {
        onView(profilePage.changeLanguageItem)
            .perform(click())
        return this
    }

    fun selectGeorgianLanguage(): ProfileSteps {
        changeLanguagePage.selectGeorgianLanguage()
        return this
    }

    fun selectEnglishLanguage(): ProfileSteps {
        changeLanguagePage.selectEnglishLanguage()
        return this
    }

    fun signOut(): ProfileSteps {
        onView(profilePage.signOutItem)
            .perform(click())
        return this
    }

    fun verifyGeorgianProfileDisplayed(): ProfileSteps {
        onView(withText("ენის შეცვლა"))
            .check(matches(isDisplayed()))
        return this
    }

    fun verifyEnglishProfileDisplayed(): ProfileSteps {
        onView(withText("Change Language"))
            .check(matches(isDisplayed()))
        return this
    }
}