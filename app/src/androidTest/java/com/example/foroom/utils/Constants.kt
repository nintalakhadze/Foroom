package com.example.foroom.utils

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimaps.index

object Constants {

    const val USER_A_USERNAME = "userA"
    const val USER_A_PASSWORD = "usera123"

    const val USER_B_USERNAME = "userB"
    const val USER_B_PASSWORD = "userb123"

    const val JOHN_WEEK_CHAT = "JohnWeek"
    const val MY_CHAT = "Nina Talakhadze"
    const val SHARED_CHAT = "Something"
    val QUESTION =
        "Which module do you like most in the Automation Academy? ${System.currentTimeMillis()}"
    val MESSAGE_FOR_JOHN = "let's go for a drink ${System.currentTimeMillis()}"
    const val GREETING_PREFIX = "Hello from User A"
    const val REPLY_PREFIX = "Hello from User B"
    const val ADDITIONAL_MESSAGE_PREFIX = "Additional message"
    const val ADDITIONAL_MESSAGE_COUNT = 25




}