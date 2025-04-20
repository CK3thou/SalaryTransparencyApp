package com.salarytracker.di

import com.salarytracker.data.repository.SalaryRepository
import com.salarytracker.data.repository.SalaryRepositoryImpl
import com.salarytracker.data.source.local.SalaryLocalDataSource
import com.salarytracker.data.source.remote.SalaryRemoteDataSource
import com.salarytracker.viewmodel.HomeViewModel
import com.salarytracker.viewmodel.SalaryDetailsViewModel
import com.salarytracker.viewmodel.SubmitSalaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    // Database
    includes(databaseModule)
    
    // Data Sources
    single { SalaryLocalDataSource(get()) }
    single { SalaryRemoteDataSource() }
    
    // Repository
    single<SalaryRepository> {
        SalaryRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }
    
    // ViewModels
    viewModel { HomeViewModel(get()) }
    viewModel { SubmitSalaryViewModel(get()) }
    viewModel { SalaryDetailsViewModel(get()) }
} 