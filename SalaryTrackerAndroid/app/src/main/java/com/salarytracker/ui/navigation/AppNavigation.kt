package com.salarytracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.salarytracker.ui.screens.home.HomeScreen
import com.salarytracker.ui.screens.submit.SubmitSalaryScreen
import com.salarytracker.ui.screens.details.SalaryDetailsScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Submit : Screen("submit")
    object Details : Screen("details/{salaryId}") {
        fun createRoute(salaryId: String) = "details/$salaryId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToSubmit = { navController.navigate(Screen.Submit.route) },
                onNavigateToDetails = { salaryId ->
                    navController.navigate(Screen.Details.createRoute(salaryId))
                }
            )
        }
        
        composable(Screen.Submit.route) {
            SubmitSalaryScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Details.route) { backStackEntry ->
            val salaryId = backStackEntry.arguments?.getString("salaryId")
            SalaryDetailsScreen(
                salaryId = salaryId ?: "",
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
} 