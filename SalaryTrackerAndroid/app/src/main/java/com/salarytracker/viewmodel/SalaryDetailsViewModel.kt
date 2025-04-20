package com.salarytracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salarytracker.data.model.SalaryData
import com.salarytracker.data.repository.SalaryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalaryDetailsViewModel(
    private val repository: SalaryRepository
) : ViewModel() {

    private val _salary = MutableStateFlow<SalaryData?>(null)
    val salary: StateFlow<SalaryData?> = _salary

    fun loadSalary(salaryId: String) {
        viewModelScope.launch {
            try {
                val salaryData = repository.getSalaryById(salaryId)
                _salary.value = salaryData
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
} 