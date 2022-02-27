package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert.assertEquals
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
  
  @Test
  fun rallyNavHost_navigateToAllAccounts_viaUI() {
    composableTestRule
      .onNodeWithContentDescription("All Accounts")
      .performClick()
    composableTestRule
      .onNodeWithContentDescription("Accounts Screen")
      .assertIsDisplayed()
  }
  
  /**
   * Use the [navController] to check assertions
   */
  @Test
  fun rallyNavHost_navigateToBills_viaUI() {
    // When click on "All Bills"
    composableTestRule
      .onNodeWithContentDescription("All Bills").apply {
        performScrollTo()
        performClick()
      }
    // Then the route is "Bills"
    val route = navController.currentBackStackEntry?.destination?.route
    assertEquals(route, "Bills")
  }
  
  /**
   * Navigate using [navController.navigate] and then assert that
   * the expected screen is displayed
   */
  @Test
  fun rallyNavHost_navigateToAllAccounts_callingNavigate() {
    // Navigation using [navController.navigate] need to be made on UI thread.
    // To achieve this, we are using coroutines on the [Main] thread dispatcher
    runBlocking {
      withContext(Dispatchers.Main) {
        navController.navigate(RallyScreen.Accounts.name)
      }
    }
    composableTestRule
      .onNodeWithContentDescription("Accounts Screen")
      .assertIsDisplayed()
  }
  
}