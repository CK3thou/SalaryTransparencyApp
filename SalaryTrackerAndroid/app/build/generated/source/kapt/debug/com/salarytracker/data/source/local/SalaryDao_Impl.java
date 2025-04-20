package com.salarytracker.data.source.local;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.salarytracker.data.model.SalaryData;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SalaryDao_Impl implements SalaryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SalaryData> __insertionAdapterOfSalaryData;

  private final DateConverter __dateConverter = new DateConverter();

  public SalaryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSalaryData = new EntityInsertionAdapter<SalaryData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `salaries` (`id`,`role`,`monthlyGrossSalary`,`salaryInUSD`,`yearsOfExperience`,`industry`,`country`,`submissionDate`,`educationLevel`,`companySize`,`remoteWorkPercentage`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalaryData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getRole() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRole());
        }
        stmt.bindDouble(3, value.getMonthlyGrossSalary());
        stmt.bindDouble(4, value.getSalaryInUSD());
        stmt.bindLong(5, value.getYearsOfExperience());
        if (value.getIndustry() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIndustry());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCountry());
        }
        final Long _tmp = __dateConverter.dateToTimestamp(value.getSubmissionDate());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp);
        }
        if (value.getEducationLevel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEducationLevel());
        }
        if (value.getCompanySize() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCompanySize());
        }
        stmt.bindLong(11, value.getRemoteWorkPercentage());
      }
    };
  }

  @Override
  public Object insertSalary(final SalaryData salary,
      final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Flow<List<SalaryData>> getAllSalaries() {
    final String _sql = "SELECT `salaries`.`id` AS `id`, `salaries`.`role` AS `role`, `salaries`.`monthlyGrossSalary` AS `monthlyGrossSalary`, `salaries`.`salaryInUSD` AS `salaryInUSD`, `salaries`.`yearsOfExperience` AS `yearsOfExperience`, `salaries`.`industry` AS `industry`, `salaries`.`country` AS `country`, `salaries`.`submissionDate` AS `submissionDate`, `salaries`.`educationLevel` AS `educationLevel`, `salaries`.`companySize` AS `companySize`, `salaries`.`remoteWorkPercentage` AS `remoteWorkPercentage` FROM salaries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"salaries"}, new Callable<List<SalaryData>>() {
      @Override
      public List<SalaryData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfRole = 1;
          final int _cursorIndexOfMonthlyGrossSalary = 2;
          final int _cursorIndexOfSalaryInUSD = 3;
          final int _cursorIndexOfYearsOfExperience = 4;
          final int _cursorIndexOfIndustry = 5;
          final int _cursorIndexOfCountry = 6;
          final int _cursorIndexOfSubmissionDate = 7;
          final int _cursorIndexOfEducationLevel = 8;
          final int _cursorIndexOfCompanySize = 9;
          final int _cursorIndexOfRemoteWorkPercentage = 10;
          final List<SalaryData> _result = new ArrayList<SalaryData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalaryData _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final double _tmpMonthlyGrossSalary;
            _tmpMonthlyGrossSalary = _cursor.getDouble(_cursorIndexOfMonthlyGrossSalary);
            final double _tmpSalaryInUSD;
            _tmpSalaryInUSD = _cursor.getDouble(_cursorIndexOfSalaryInUSD);
            final int _tmpYearsOfExperience;
            _tmpYearsOfExperience = _cursor.getInt(_cursorIndexOfYearsOfExperience);
            final String _tmpIndustry;
            if (_cursor.isNull(_cursorIndexOfIndustry)) {
              _tmpIndustry = null;
            } else {
              _tmpIndustry = _cursor.getString(_cursorIndexOfIndustry);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final Date _tmpSubmissionDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfSubmissionDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfSubmissionDate);
            }
            _tmpSubmissionDate = __dateConverter.fromTimestamp(_tmp);
            final String _tmpEducationLevel;
            if (_cursor.isNull(_cursorIndexOfEducationLevel)) {
              _tmpEducationLevel = null;
            } else {
              _tmpEducationLevel = _cursor.getString(_cursorIndexOfEducationLevel);
            }
            final String _tmpCompanySize;
            if (_cursor.isNull(_cursorIndexOfCompanySize)) {
              _tmpCompanySize = null;
            } else {
              _tmpCompanySize = _cursor.getString(_cursorIndexOfCompanySize);
            }
            final int _tmpRemoteWorkPercentage;
            _tmpRemoteWorkPercentage = _cursor.getInt(_cursorIndexOfRemoteWorkPercentage);
            _item = new SalaryData(_tmpId,_tmpRole,_tmpMonthlyGrossSalary,_tmpSalaryInUSD,_tmpYearsOfExperience,_tmpIndustry,_tmpCountry,_tmpSubmissionDate,_tmpEducationLevel,_tmpCompanySize,_tmpRemoteWorkPercentage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SalaryData>> getSalariesByCountry(final String country) {
    final String _sql = "SELECT * FROM salaries WHERE country = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (country == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, country);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"salaries"}, new Callable<List<SalaryData>>() {
      @Override
      public List<SalaryData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfMonthlyGrossSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyGrossSalary");
          final int _cursorIndexOfSalaryInUSD = CursorUtil.getColumnIndexOrThrow(_cursor, "salaryInUSD");
          final int _cursorIndexOfYearsOfExperience = CursorUtil.getColumnIndexOrThrow(_cursor, "yearsOfExperience");
          final int _cursorIndexOfIndustry = CursorUtil.getColumnIndexOrThrow(_cursor, "industry");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfSubmissionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "submissionDate");
          final int _cursorIndexOfEducationLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "educationLevel");
          final int _cursorIndexOfCompanySize = CursorUtil.getColumnIndexOrThrow(_cursor, "companySize");
          final int _cursorIndexOfRemoteWorkPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteWorkPercentage");
          final List<SalaryData> _result = new ArrayList<SalaryData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalaryData _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final double _tmpMonthlyGrossSalary;
            _tmpMonthlyGrossSalary = _cursor.getDouble(_cursorIndexOfMonthlyGrossSalary);
            final double _tmpSalaryInUSD;
            _tmpSalaryInUSD = _cursor.getDouble(_cursorIndexOfSalaryInUSD);
            final int _tmpYearsOfExperience;
            _tmpYearsOfExperience = _cursor.getInt(_cursorIndexOfYearsOfExperience);
            final String _tmpIndustry;
            if (_cursor.isNull(_cursorIndexOfIndustry)) {
              _tmpIndustry = null;
            } else {
              _tmpIndustry = _cursor.getString(_cursorIndexOfIndustry);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final Date _tmpSubmissionDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfSubmissionDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfSubmissionDate);
            }
            _tmpSubmissionDate = __dateConverter.fromTimestamp(_tmp);
            final String _tmpEducationLevel;
            if (_cursor.isNull(_cursorIndexOfEducationLevel)) {
              _tmpEducationLevel = null;
            } else {
              _tmpEducationLevel = _cursor.getString(_cursorIndexOfEducationLevel);
            }
            final String _tmpCompanySize;
            if (_cursor.isNull(_cursorIndexOfCompanySize)) {
              _tmpCompanySize = null;
            } else {
              _tmpCompanySize = _cursor.getString(_cursorIndexOfCompanySize);
            }
            final int _tmpRemoteWorkPercentage;
            _tmpRemoteWorkPercentage = _cursor.getInt(_cursorIndexOfRemoteWorkPercentage);
            _item = new SalaryData(_tmpId,_tmpRole,_tmpMonthlyGrossSalary,_tmpSalaryInUSD,_tmpYearsOfExperience,_tmpIndustry,_tmpCountry,_tmpSubmissionDate,_tmpEducationLevel,_tmpCompanySize,_tmpRemoteWorkPercentage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getSalaryById(final String id, final Continuation<? super SalaryData> $completion) {
    final String _sql = "SELECT * FROM salaries WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Object _result;
      if(_cursor.moveToFirst()) {
        _result = new Object();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getCountries(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT DISTINCT country FROM salaries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    int _argIndex = 1;
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Object _result;
      if(_cursor.moveToFirst()) {
        _result = new Object();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getIndustries(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT DISTINCT industry FROM salaries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    int _argIndex = 1;
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Object _result;
      if(_cursor.moveToFirst()) {
        _result = new Object();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
