package com.salarytracker.viewmodel;

import androidx.lifecycle.ViewModel;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.repository.SalaryRepository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/salarytracker/viewmodel/SubmitSalaryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/salarytracker/data/repository/SalaryRepository;", "(Lcom/salarytracker/data/repository/SalaryRepository;)V", "submitSalary", "", "salary", "Lcom/salarytracker/data/model/SalaryData;", "app_debug"})
public final class SubmitSalaryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.salarytracker.data.repository.SalaryRepository repository = null;
    
    public SubmitSalaryViewModel(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.repository.SalaryRepository repository) {
        super();
    }
    
    public final void submitSalary(@org.jetbrains.annotations.NotNull()
    com.salarytracker.data.model.SalaryData salary) {
    }
}