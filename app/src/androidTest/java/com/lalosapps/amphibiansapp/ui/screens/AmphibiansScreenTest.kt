package com.lalosapps.amphibiansapp.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import com.lalosapps.amphibiansapp.R

class AmphibiansScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun appLaunch_onLoadingUiState_verifyCircularProgressDisplayed() {
        FakeUiStateSource.setLoadingState()
        composeTestRule.setContent {
            AmphibiansScreen(uiState = FakeUiStateSource.uiState.collectAsState().value)
        }
        composeTestRule
            .onNodeWithTag("screenCircularProgress")
            .assertIsDisplayed()
    }

    @Test
    fun appLaunch_onSuccessUiState_verifyFirstListItemDisplayed() {
        FakeUiStateSource.setSuccessState()
        composeTestRule.setContent {
            AmphibiansScreen(uiState = FakeUiStateSource.uiState.collectAsState().value)
        }
        composeTestRule
            .onNodeWithText(FakeUiStateSource.amphibians.first().description)
            .assertIsDisplayed()
    }

    @Test
    fun appLaunch_onErrorUiState_verifyErrorMessageDisplayed() {
        FakeUiStateSource.setErrorState()
        composeTestRule.setContent {
            AmphibiansScreen(uiState = FakeUiStateSource.uiState.collectAsState().value)
        }
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.error_message))
            .assertIsDisplayed()
    }
}