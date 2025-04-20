package com.salarytracker.data.source.remote

import com.salarytracker.data.model.SalaryData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SalaryApi {
    @GET("salaries")
    suspend fun getSalaries(): Response<List<SalaryData>>

    @POST("salaries")
    suspend fun addSalary(@Body salary: SalaryData): Response<Unit>
}

class SalaryRemoteDataSource {
    private val api: SalaryApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://your-api-base-url.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SalaryApi::class.java)
    }

    suspend fun addSalary(salary: SalaryData) {
        try {
            val response = api.addSalary(salary)
            if (!response.isSuccessful) {
                throw Exception("Failed to add salary: ${response.code()}")
            }
        } catch (e: Exception) {
            throw Exception("Network error: ${e.message}")
        }
    }
} 