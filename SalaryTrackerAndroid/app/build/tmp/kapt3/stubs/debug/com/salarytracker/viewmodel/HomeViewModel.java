package com.salarytracker.viewmodel;

import androidx.lifecycle.ViewModel;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import com.salarytracker.data.repository.SalaryRepository;
import kotlinx.coroutines.flow.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/salarytracker/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/salarytracker/data/repository/SalaryRepository;", "(Lcom/salarytracker/data/repository/SalaryRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/salarytracker/viewmodel/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "filterByCountry", "", "country", "", "loadInitialData", "refreshData", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.salarytracker.data.repository.SalaryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.salarytracker.viewmodel.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.salarytracker.viewmodel.HomeUiState> uiState = null;
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.repository.SalaryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.salarytracker.viewmodel.HomeUiState> getUiState() {
        return null;
    }
    
    private final void loadInitialData() {
    }
    
    public final void filterByCountry(@org.jetbrains.annotations.NotNull()
    java.lang.String country) {
    }
    
    public final void refreshData() {
    }
}