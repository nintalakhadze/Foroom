package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.pages.LoginPage

class LoginSteps{
    private val loginPage = LoginPage()

    fun login(username: String, password: String) {
        loginPage.enterUsername(username)
        loginPage.enterPassword(password)
        loginPage.clickLoginButton()
    }
    fun goToRegistration() {
        loginPage.clickSignUpButton()
    }

    fun verifyLoginScreenDisplayed(){
        onView(loginPage.loginButton).check(matches(isDisplayed()))
    }
    fun verifyUsernameErrorDisplayed(){
        onView(loginPage.usernameErrorMessage).check(matches(isDisplayed()))
    }
    fun verifyPasswordErrorDisplayed(){
        onView(loginPage.passwordErrorMessage).check(matches(isDisplayed()))
    }
    fun ensureLoginScreenDisplayed() {
        if (loginPage.loginButton.isViewDisplayed()) {
            return
        }

        loginPage.clickProfileButton()
        loginPage.clickSignOut()

        onView(loginPage.loginButton)
            .check(matches(isDisplayed()))
    }
    fun verifyHomeScreenDisplayed() {
        onView(loginPage.navBar)
            .check(matches(isDisplayed()))
    }
    }
