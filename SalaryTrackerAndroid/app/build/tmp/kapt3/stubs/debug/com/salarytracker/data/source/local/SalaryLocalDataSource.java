package com.salarytracker.data.source.local;

import androidx.room.*;
import androidx.room.TypeConverters;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import kotlinx.coroutines.flow.Flow;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/salarytracker/data/source/local/SalaryLocalDataSource;", "", "dao", "Lcom/salarytracker/data/source/local/SalaryDao;", "(Lcom/salarytracker/data/source/local/SalaryDao;)V", "addSalary", "", "salary", "Lcom/salarytracker/data/model/SalaryData;", "(Lcom/salarytracker/data/model/SalaryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSalaries", "Lkotlinx/coroutines/flow/Flow;", "", "getCountries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilteredSalaries", "filter", "Lcom/salarytracker/data/model/SalaryFilter;", "getIndustries", "getSalaryById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SalaryLocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.salarytracker.data.source.local.SalaryDao dao = null;
    
    public SalaryLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.source.local.SalaryDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.salarytracker.data.model.SalaryData>> getAllSalaries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.salarytracker.data.model.SalaryData>> getFilteredSalaries(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryFilter filter) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addSalary(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSalaryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.salarytracker.data.model.SalaryData> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCountries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getIndustries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
}