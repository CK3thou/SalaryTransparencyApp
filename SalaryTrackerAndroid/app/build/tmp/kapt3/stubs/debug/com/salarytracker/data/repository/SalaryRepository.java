package com.salarytracker.data.repository;

import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\u0014\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0015\u00c0\u0006\u0001"}, d2 = {"Lcom/salarytracker/data/repository/SalaryRepository;", "", "addSalary", "", "salary", "Lcom/salarytracker/data/model/SalaryData;", "(Lcom/salarytracker/data/model/SalaryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSalaries", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountries", "", "getFilteredSalaries", "filter", "Lcom/salarytracker/data/model/SalaryFilter;", "(Lcom/salarytracker/data/model/SalaryFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndustries", "getSalaryById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SalaryRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllSalaries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.salarytracker.data.model.SalaryData>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFilteredSalaries(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryFilter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.salarytracker.data.model.SalaryData>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addSalary(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSalaryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.salarytracker.data.model.SalaryData> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCountries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIndustries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
}