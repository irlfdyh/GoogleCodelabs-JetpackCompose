package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RallyNavHostTest {
  
  @get:Rule
  val composableTestRule = createComposeRule()
  
  lateinit var navController: NavHostController
  
  @Before
  fun setupRallyNavHost() {
    composableTestRule.setContent {
      navController = rememberNavController()
      RallyNavHost(navController = navController)
    }
  }
  
  @Test
  fun rallyNavHost() {
    composableTestRule
      .onNodeWithContentDescription("Overview Screen")
      .assertIsDisplayed()
  }
  
}