package com.salarytracker.ui.screens.submit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.salarytracker.R
import com.salarytracker.data.model.SalaryData
import com.salarytracker.viewmodel.SubmitSalaryViewModel
import org.koin.androidx.compose.getViewModel
import java.util.*

@Composable
fun SubmitSalaryScreen(
    onNavigateBack: () -> Unit,
    viewModel: SubmitSalaryViewModel = getViewModel()
) {
    var role by remember { mutableStateOf("") }
    var monthlyGrossSalary by remember { mutableStateOf("") }
    var yearsOfExperience by remember { mutableStateOf("") }
    var industry by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var educationLevel by remember { mutableStateOf("") }
    var companySize by remember { mutableStateOf("") }
    var remoteWorkPercentage by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.submit_salary)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = role,
                onValueChange = { role = it },
                label = { Text("Role") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = monthlyGrossSalary,
                onValueChange = { monthlyGrossSalary = it },
                label = { Text("Monthly Gross Salary (ZMW)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = yearsOfExperience,
                onValueChange = { yearsOfExperience = it },
                label = { Text("Years of Experience") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = industry,
                onValueChange = { industry = it },
                label = { Text("Industry") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = country,
                onValueChange = { country = it },
                label = { Text("Country") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = educationLevel,
                onValueChange = { educationLevel = it },
                label = { Text("Education Level") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = companySize,
                onValueChange = { companySize = it },
                label = { Text("Company Size") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = remoteWorkPercentage,
                onValueChange = { remoteWorkPercentage = it },
                label = { Text("Remote Work Percentage") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val salary = SalaryData(
                        role = role,
                        monthlyGrossSalary = monthlyGrossSalary.toDoubleOrNull() ?: 0.0,
                        salaryInUSD = 0.0, // This would be calculated based on exchange rate
                        yearsOfExperience = yearsOfExperience.toIntOrNull() ?: 0,
                        industry = industry,
                        country = country,
                        educationLevel = educationLevel,
                        companySize = companySize,
                        remoteWorkPercentage = remoteWorkPercentage.toIntOrNull() ?: 0
                    )
                    viewModel.submitSalary(salary)
                    onNavigateBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
} 