package com.salarytracker.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salarytracker.data.model.SalaryData
import com.salarytracker.ui.components.SalaryChart
import com.salarytracker.ui.components.SalaryListItem
import com.salarytracker.ui.components.CountryFilter
import com.salarytracker.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    onNavigateToSubmit: () -> Unit,
    onNavigateToDetails: (String) -> Unit,
    viewModel: HomeViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedCountry by remember { mutableStateOf("All Countries") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToSubmit) {
                Icon(Icons.Default.Add, contentDescription = "Add Salary")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                CountryFilter(
                    selectedCountry = selectedCountry,
                    onCountrySelected = { country ->
                        selectedCountry = country
                        viewModel.filterByCountry(country)
                    }
                )
            }

            item {
                SalaryChart(
                    salaryData = uiState.filteredSalaries,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(16.dp)
                )
            }

            items(uiState.filteredSalaries) { salary ->
                SalaryListItem(
                    salary = salary,
                    onClick = { onNavigateToDetails(salary.id) }
                )
            }
        }
    }
} 