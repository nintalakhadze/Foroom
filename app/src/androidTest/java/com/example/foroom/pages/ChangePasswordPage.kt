package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf

class ChangePasswordPage {

    val passwordEditText = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.passwordInput))
    )

    val repeatPasswordEditText = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.repeatPasswordInput))
    )

    val confirmButton =
        withId(com.example.design_system.R.id.actionButton)

    fun enterPassword(password: String) {
        onView(passwordEditText)
            .perform(replaceText(password))
    }

    fun enterRepeatPassword(password: String) {
        onView(repeatPasswordEditText)
            .perform(replaceText(password))
    }

    fun clickConfirmButton() {
        onView(confirmButton)
            .perform(click())
    }
}