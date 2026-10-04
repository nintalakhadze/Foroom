package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.alternator.foroom.R
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf

class LoginPage {
     val usernameEditText = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.userNameInput))
    )
     val passwordEditText = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.passwordInput))
    )

     val loginButton = withId(R.id.logInButton)

     val signUpButton = withId(R.id.signUpButton)

    fun enterUsername(username: String) {
        onView(usernameEditText)
            .perform(replaceText(username))
    }

    fun enterPassword(password: String) {
        onView(passwordEditText)
            .perform(replaceText(password))
    }

    fun clickLoginButton() {
        onView(loginButton)
            .perform(click())
    }

    fun clickSignUpButton() {
        onView(signUpButton)
            .perform(click())
    }
    val usernameErrorMessage = allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        isDescendantOfA(withId(R.id.userNameInput))
    )

    val passwordErrorMessage = allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        isDescendantOfA(withId(R.id.passwordInput))
    )
    val profileButton = withId(R.id.homeNavigationProfile)
    val signOutItem = withId(R.id.signOutItem)
    val navBar = withId(R.id.navBar)

    fun clickProfileButton() {
        onView(profileButton).perform(click())
    }

    fun clickSignOut() {
        onView(signOutItem).perform(click())
    }
}