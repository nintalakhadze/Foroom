package com.example.foroom.steps

import com.example.foroom.pages.ChatsPage
import com.example.foroom.pages.CreateChatPage

class ChatSteps {

    private val createChatPage = CreateChatPage()
    private val chatsPage = ChatsPage()

    fun openCreateChat() {
        createChatPage.clickCreateChatNavigationButton()
    }

    fun enterChatName(chatName: String) {
        createChatPage.enterChatName(chatName)
    }

    fun openChatImageChooser() {
        createChatPage.clickChatImageChooser()
    }

    fun selectChatImage(index: Int = 0) {
        createChatPage.selectChatImage(index)
    }

    fun createChat() {
        createChatPage.clickCreateChatButton()
    }

    fun verifyCreatedChatOpened(chatName: String) {
        createChatPage.verifyCreatedChatName(chatName)
    }

    fun closeChat() {
        createChatPage.clickCloseButton()
    }

    fun searchChat(chatName: String) {
        chatsPage.searchChat(chatName)
    }

    fun verifyChatDisplayedInList(chatName: String) {
        chatsPage.verifyChatDisplayed(chatName)
    }
}