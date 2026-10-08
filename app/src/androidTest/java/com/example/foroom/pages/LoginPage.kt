package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
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
}