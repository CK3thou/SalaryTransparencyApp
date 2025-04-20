package com.salarytracker.data.source.remote;

import com.salarytracker.data.model.SalaryData;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2 = {"Lcom/salarytracker/data/source/remote/SalaryApi;", "", "addSalary", "Lretrofit2/Response;", "", "salary", "Lcom/salarytracker/data/model/SalaryData;", "(Lcom/salarytracker/data/model/SalaryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSalaries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SalaryApi {
    
    @retrofit2.http.GET(value = "salaries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSalaries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.salarytracker.data.model.SalaryData>>> $completion);
    
    @retrofit2.http.POST(value = "salaries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addSalary(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}