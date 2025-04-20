package com.salarytracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.salarytracker.data.source.local.DateConverter
import java.util.*

@Entity(tableName = "salaries")
@TypeConverters(DateConverter::class)
data class SalaryData(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val role: String,
    val monthlyGrossSalary: Double,
    val salaryInUSD: Double,
    val yearsOfExperience: Int,
    val industry: String,
    val country: String,
    val submissionDate: Date = Date(),
    val educationLevel: String,
    val companySize: String,
    val remoteWorkPercentage: Int
)

data class SalaryFilter(
    val country: String = "All Countries",
    val industry: String = "All Industries",
    val experienceRange: IntRange = 0..100
) 