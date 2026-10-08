package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.Helper.tap
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.endsWith

class CreateChatPage {

    val createChatNavigationButton =
        withId(R.id.homeNavigationCreateChat)

    val chatNameInput = allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.chatNameInput))
    )

    val chatImageChooser =
        withId(R.id.chatImageChooser)

    val chatImageItem =
        withClassName(endsWith("ImageChooserItemView"))

    val createChatButton =
        withId(R.id.createChatButton)

    val chatNameTextView =
        withId(com.example.design_system.R.id.chatNameTextView)

    val closeButton =
        withId(R.id.closeButton)

    fun clickCreateChatNavigationButton() {
        onView(createChatNavigationButton)
            .perform(click())
    }

    fun enterChatName(chatName: String) {
        onView(chatNameInput)
            .perform(replaceText(chatName))
    }

    fun clickChatImageChooser() {
        onView(chatImageChooser)
            .perform(click())
    }

    fun selectChatImage(index: Int = 0) {
        chatImageItem.tap(byPosition = index)
    }

    fun clickCreateChatButton() {
        onView(createChatButton)
            .perform(click())
    }

    fun verifyCreatedChatName(chatName: String) {
        onView(chatNameTextView)
            .check(
                matches(
                    allOf(
                        withText(chatName),
                        isDisplayed()
                    )
                )
            )
    }

    fun clickCloseButton() {
        onView(closeButton)
            .perform(click())
    }
}