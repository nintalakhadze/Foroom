package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R

class ProfilePage {

    val profileButton = withId(R.id.homeNavigationProfile)

    val changePasswordItem = withId(R.id.changePasswordItem)

    val changeLanguageItem = withId(R.id.changeLanguageItem)

    val signOutItem = withId(R.id.signOutItem)
}