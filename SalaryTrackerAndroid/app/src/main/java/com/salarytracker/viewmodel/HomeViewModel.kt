package com.salarytracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salarytracker.data.model.SalaryData
import com.salarytracker.data.model.SalaryFilter
import com.salarytracker.data.repository.SalaryRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val filteredSalaries: List<SalaryData> = emptyList(),
    val countries: List<String> = emptyList(),
    val industries: List<String> = emptyList()
)

class HomeViewModel(
    private val repository: SalaryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                
                val countries = repository.getCountries()
                val industries = repository.getIndustries()
                
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        countries = countries,
                        industries = industries
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An error occurred"
                    )
                }
            }
        }
    }

    fun filterByCountry(country: String) {
        viewModelScope.launch {
            try {
                val filter = SalaryFilter(country = country)
                repository.getFilteredSalaries(filter)
                    .collect { salaries ->
                        _uiState.update {
                            it.copy(filteredSalaries = salaries)
                        }
                    }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = e.message ?: "An error occurred while filtering")
                }
            }
        }
    }

    fun refreshData() {
        loadInitialData()
    }
} 