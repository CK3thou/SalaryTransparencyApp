package com.salarytracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salarytracker.data.model.SalaryData
import com.salarytracker.data.repository.SalaryRepository
import kotlinx.coroutines.launch

class SubmitSalaryViewModel(
    private val repository: SalaryRepository
) : ViewModel() {

    fun submitSalary(salary: SalaryData) {
        viewModelScope.launch {
            try {
                repository.addSalary(salary)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
} 