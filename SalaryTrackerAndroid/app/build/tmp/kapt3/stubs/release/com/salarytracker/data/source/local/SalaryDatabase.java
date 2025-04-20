package com.salarytracker.data.source.local;

import androidx.room.*;
import androidx.room.TypeConverters;
import com.salarytracker.data.model.SalaryData;
import com.salarytracker.data.model.SalaryFilter;
import kotlinx.coroutines.flow.Flow;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/salarytracker/data/source/local/SalaryDatabase;", "Landroidx/room/RoomDatabase;", "()V", "salaryDao", "Lcom/salarytracker/data/source/local/SalaryDao;", "app_release"})
@androidx.room.Database(entities = {com.salarytracker.data.model.SalaryData.class}, version = 1)
@androidx.room.TypeConverters(value = {com.salarytracker.data.source.local.DateConverter.class})
public abstract class SalaryDatabase extends androidx.room.RoomDatabase {
    
    public SalaryDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.salarytracker.data.source.local.SalaryDao salaryDao();
}