package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.pages.LoginPage

class LoginSteps {

    private val loginPage = LoginPage()

    fun enterUsername(username: String): LoginSteps {
        onView(loginPage.usernameEditText)
            .perform(replaceText(username))
        return this
    }

    fun enterPassword(password: String): LoginSteps {
        onView(loginPage.passwordEditText)
            .perform(replaceText(password))
        return this
    }

    fun clickLoginButton(): LoginSteps {
        onView(loginPage.loginButton)
            .perform(click())
        return this
    }

    fun login(username: String, password: String): LoginSteps {
        return enterUsername(username)
            .enterPassword(password)
            .clickLoginButton()
    }

    fun goToRegistration(): LoginSteps {
        onView(loginPage.signUpButton)
            .perform(click())
        return this
    }

    fun verifyLoginScreenDisplayed(): LoginSteps {
        onView(loginPage.loginButton)
            .check(matches(isDisplayed()))
        return this
    }

    fun verifyUsernameErrorDisplayed(): LoginSteps {
        onView(loginPage.usernameErrorMessage)
            .check(matches(isDisplayed()))
        return this
    }

    fun verifyPasswordErrorDisplayed(): LoginSteps {
        onView(loginPage.passwordErrorMessage)
            .check(matches(isDisplayed()))
        return this
    }

    fun openProfile(): LoginSteps {
        onView(loginPage.profileButton)
            .perform(click())
        return this
    }

    fun signOut(): LoginSteps {
        onView(loginPage.signOutItem)
            .perform(click())
        return this
    }

    fun ensureLoginScreenDisplayed(): LoginSteps {
        if (loginPage.loginButton.isViewDisplayed()) {
            return this
        }

        return openProfile()
            .signOut()
            .verifyLoginScreenDisplayed()
    }

    fun verifyHomeScreenDisplayed(): LoginSteps {
        onView(loginPage.navBar)
            .check(matches(isDisplayed()))
        return this
    }
}