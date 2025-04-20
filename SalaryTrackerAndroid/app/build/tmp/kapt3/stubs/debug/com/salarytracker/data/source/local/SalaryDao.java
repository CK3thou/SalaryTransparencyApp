package com.salarytracker.data.source.local;

import androidx.room.*;
import androidx.room.TypeConverters;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import kotlinx.coroutines.flow.Flow;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\'J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2 = {"Lcom/salarytracker/data/source/local/SalaryDao;", "", "getAllSalaries", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/salarytracker/data/model/SalaryData;", "getCountries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndustries", "getSalariesByCountry", "country", "getSalaryById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSalary", "", "salary", "(Lcom/salarytracker/data/model/SalaryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface SalaryDao {
    
    @androidx.room.Query(value = "SELECT * FROM salaries")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.salarytracker.data.model.SalaryData>> getAllSalaries();
    
    @androidx.room.Query(value = "SELECT * FROM salaries WHERE country = :country")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.salarytracker.data.model.SalaryData>> getSalariesByCountry(@org.jetbrains.annotations.NotNull()
    java.lang.String country);
    
    @androidx.room.Query(value = "SELECT * FROM salaries WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSalaryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.salarytracker.data.model.SalaryData> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSalary(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT country FROM salaries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCountries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT industry FROM salaries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIndustries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
}