package com.salarytracker.di

import android.content.Context
import androidx.room.Room
import com.salarytracker.data.source.local.SalaryDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            SalaryDatabase::class.java,
            "salary_database"
        ).build()
    }
    
    single { get<SalaryDatabase>().salaryDao() }
} 