package com.salarytracker

import android.app.Application
import com.salarytracker.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SalaryTrackerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Koin for dependency injection
        startKoin {
            androidContext(this@SalaryTrackerApplication)
            modules(AppModule.module)
        }
    }
} 