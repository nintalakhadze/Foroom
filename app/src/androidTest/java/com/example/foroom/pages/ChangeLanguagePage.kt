package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R

class ChangeLanguagePage {

    val georgianLanguageButton = withId(R.id.languageButtonGeo)
    val englishLanguageButton = withId(R.id.languageButtonEng)

    fun selectGeorgianLanguage() {
        onView(georgianLanguageButton).perform(click())
    }

    fun selectEnglishLanguage() {
        onView(englishLanguageButton).perform(click())
    }
}