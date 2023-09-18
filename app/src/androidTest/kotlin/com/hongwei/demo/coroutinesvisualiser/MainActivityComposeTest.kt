package com.hongwei.demo.coroutinesvisualiser

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.hongwei.demo.coroutinesvisualiser.ui.theme.CoroutinesVisualiserTheme
import org.junit.Rule
import org.junit.Test

class MainActivityComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun testGreeting() {
        // Start the app
        composeTestRule.setContent {
            CoroutinesVisualiserTheme {
                Greeting("test name string")
            }
        }

        composeTestRule.onNodeWithTag("greetingText").assertIsDisplayed()
        composeTestRule.onNodeWithTag("greetingText").assertTextEquals("Hello test name string!")
        composeTestRule.onNodeWithText("Hello test name string!").assertIsDisplayed()
    }
}