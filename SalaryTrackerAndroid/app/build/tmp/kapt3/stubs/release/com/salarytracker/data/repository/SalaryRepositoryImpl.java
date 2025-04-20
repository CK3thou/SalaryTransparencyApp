package com.salarytracker.data.repository;

import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0019R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/salarytracker/data/repository/SalaryRepositoryImpl;", "Lcom/salarytracker/data/repository/SalaryRepository;", "localDataSource", "error/NonExistentClass", "remoteDataSource", "(Lerror/NonExistentClass;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "addSalary", "", "salary", "Lcom/salarytracker/data/model/SalaryData;", "(Lcom/salarytracker/data/model/SalaryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSalaries", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountries", "", "getFilteredSalaries", "filter", "Lcom/salarytracker/data/model/SalaryFilter;", "(Lcom/salarytracker/data/model/SalaryFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndustries", "getSalaryById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class SalaryRepositoryImpl implements com.salarytracker.data.repository.SalaryRepository {
    @org.jetbrains.annotations.NotNull()
    private final SalaryLocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final SalaryRemoteDataSource remoteDataSource = null;
    
    public SalaryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    SalaryLocalDataSource localDataSource, @org.jetbrains.annotations.NotNull()
    SalaryRemoteDataSource remoteDataSource) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllSalaries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.salarytracker.data.model.SalaryData>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getFilteredSalaries(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryFilter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.salarytracker.data.model.SalaryData>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addSalary(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSalaryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.salarytracker.data.model.SalaryData> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCountries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getIndustries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
}