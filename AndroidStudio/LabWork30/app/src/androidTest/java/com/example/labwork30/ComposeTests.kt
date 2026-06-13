package com.example.labwork30

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import org.junit.Rule
import org.junit.Test

class ComposeTests {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun Greeeting_increase_on_click(){
        composeRule.setContent {
            GreetingAuthorization()
        }

        composeRule
            .onNodeWithTag("isCorrectLoginAndPassword", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("Not entered")

        composeRule
            .onNodeWithTag("insertLogin", useUnmergedTree = true)
            .assertExists()
            .performTextInput("Cava")

        composeRule
            .onNodeWithTag("insertPassword", useUnmergedTree = true)
            .assertExists()
            .performTextInput("123")

        composeRule
            .onNodeWithTag("buttonIsCorrect")
            .performClick()

        composeRule
            .onNodeWithTag("isCorrectLoginAndPassword", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("You are logged in")

        composeRule
            .onNodeWithTag("insertPassword", useUnmergedTree = true)
            .assertExists()
            .performTextReplacement("1234")

        composeRule
            .onNodeWithTag("buttonIsCorrect")
            .performClick()

        composeRule
            .onNodeWithTag("isCorrectLoginAndPassword", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("Invalid username or password")
    }
}