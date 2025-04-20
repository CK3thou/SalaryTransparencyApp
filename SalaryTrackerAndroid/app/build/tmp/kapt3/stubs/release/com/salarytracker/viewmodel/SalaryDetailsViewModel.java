package com.salarytracker.viewmodel;

import androidx.lifecycle.ViewModel;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.repository.SalaryRepository;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/salarytracker/viewmodel/SalaryDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/salarytracker/data/repository/SalaryRepository;", "(Lcom/salarytracker/data/repository/SalaryRepository;)V", "_salary", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/salarytracker/data/model/SalaryData;", "salary", "Lkotlinx/coroutines/flow/StateFlow;", "getSalary", "()Lkotlinx/coroutines/flow/StateFlow;", "loadSalary", "", "salaryId", "", "app_release"})
public final class SalaryDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.salarytracker.data.repository.SalaryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.salarytracker.data.model.SalaryData> _salary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.salarytracker.data.model.SalaryData> salary = null;
    
    public SalaryDetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.repository.SalaryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.salarytracker.data.model.SalaryData> getSalary() {
        return null;
    }
    
    public final void loadSalary(@org.jetbrains.annotations.NotNull()
    java.lang.String salaryId) {
    }
}