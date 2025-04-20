package com.salarytracker.data.repository

import com.salarytracker.data.model.SalaryData
import com.salarytracker.data.model.SalaryFilter
import kotlinx.coroutines.flow.Flow

interface SalaryRepository {
    suspend fun getAllSalaries(): Flow<List<SalaryData>>
    suspend fun getFilteredSalaries(filter: SalaryFilter): Flow<List<SalaryData>>
    suspend fun addSalary(salary: SalaryData)
    suspend fun getSalaryById(id: String): SalaryData?
    suspend fun getCountries(): List<String>
    suspend fun getIndustries(): List<String>
}

class SalaryRepositoryImpl(
    private val localDataSource: SalaryLocalDataSource,
    private val remoteDataSource: SalaryRemoteDataSource
) : SalaryRepository {
    
    override suspend fun getAllSalaries(): Flow<List<SalaryData>> {
        return localDataSource.getAllSalaries()
    }

    override suspend fun getFilteredSalaries(filter: SalaryFilter): Flow<List<SalaryData>> {
        return localDataSource.getFilteredSalaries(filter)
    }

    override suspend fun addSalary(salary: SalaryData) {
        remoteDataSource.addSalary(salary)
        localDataSource.addSalary(salary)
    }

    override suspend fun getSalaryById(id: String): SalaryData? {
        return localDataSource.getSalaryById(id)
    }

    override suspend fun getCountries(): List<String> {
        return localDataSource.getCountries()
    }

    override suspend fun getIndustries(): List<String> {
        return localDataSource.getIndustries()
    }
} 