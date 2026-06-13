package com.example.testingapp2

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ComposeTests {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun Counter_increase_on_click(){
        composeRule.setContent {
            Counter()
        }

        composeRule
            .onNodeWithTag("countLabel", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("0")

        composeRule
            .onNodeWithTag("button")
            .performClick()

        composeRule
            .onNodeWithTag("countLabel", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("1")
    }
}