package com.salarytracker.data.source.local

import androidx.room.*
import androidx.room.TypeConverters
import com.salarytracker.data.model.SalaryData
import com.salarytracker.data.model.SalaryFilter
import kotlinx.coroutines.flow.Flow
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

@Dao
interface SalaryDao {
    @Query("SELECT * FROM salaries")
    fun getAllSalaries(): Flow<List<SalaryData>>

    @Query("SELECT * FROM salaries WHERE country = :country")
    fun getSalariesByCountry(country: String): Flow<List<SalaryData>>

    @Query("SELECT * FROM salaries WHERE id = :id")
    suspend fun getSalaryById(id: String): SalaryData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSalary(salary: SalaryData)

    @Query("SELECT DISTINCT country FROM salaries")
    suspend fun getCountries(): List<String>

    @Query("SELECT DISTINCT industry FROM salaries")
    suspend fun getIndustries(): List<String>
}

@Database(entities = [SalaryData::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class SalaryDatabase : RoomDatabase() {
    abstract fun salaryDao(): SalaryDao
}

class SalaryLocalDataSource(
    private val dao: SalaryDao
) {
    fun getAllSalaries(): Flow<List<SalaryData>> = dao.getAllSalaries()

    fun getFilteredSalaries(filter: SalaryFilter): Flow<List<SalaryData>> {
        return if (filter.country == "All Countries") {
            dao.getAllSalaries()
        } else {
            dao.getSalariesByCountry(filter.country)
        }
    }

    suspend fun addSalary(salary: SalaryData) {
        dao.insertSalary(salary)
    }

    suspend fun getSalaryById(id: String): SalaryData? {
        return dao.getSalaryById(id)
    }

    suspend fun getCountries(): List<String> {
        return dao.getCountries()
    }

    suspend fun getIndustries(): List<String> {
        return dao.getIndustries()
    }
} 