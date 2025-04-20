package com.salarytracker.data.source.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SalaryDatabase_Impl extends SalaryDatabase {
  private volatile SalaryDao _salaryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `salaries` (`id` TEXT NOT NULL, `role` TEXT NOT NULL, `monthlyGrossSalary` REAL NOT NULL, `salaryInUSD` REAL NOT NULL, `yearsOfExperience` INTEGER NOT NULL, `industry` TEXT NOT NULL, `country` TEXT NOT NULL, `submissionDate` INTEGER NOT NULL, `educationLevel` TEXT NOT NULL, `companySize` TEXT NOT NULL, `remoteWorkPercentage` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6802863250a706ad7c130ed443c47584')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `salaries`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSalaries = new HashMap<String, TableInfo.Column>(11);
        _columnsSalaries.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("monthlyGrossSalary", new TableInfo.Column("monthlyGrossSalary", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("salaryInUSD", new TableInfo.Column("salaryInUSD", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("yearsOfExperience", new TableInfo.Column("yearsOfExperience", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("industry", new TableInfo.Column("industry", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("submissionDate", new TableInfo.Column("submissionDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("educationLevel", new TableInfo.Column("educationLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("companySize", new TableInfo.Column("companySize", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalaries.put("remoteWorkPercentage", new TableInfo.Column("remoteWorkPercentage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalaries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSalaries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSalaries = new TableInfo("salaries", _columnsSalaries, _foreignKeysSalaries, _indicesSalaries);
        final TableInfo _existingSalaries = TableInfo.read(_db, "salaries");
        if (! _infoSalaries.equals(_existingSalaries)) {
          return new RoomOpenHelper.ValidationResult(false, "salaries(com.salarytracker.data.model.SalaryData).\n"
                  + " Expected:\n" + _infoSalaries + "\n"
                  + " Found:\n" + _existingSalaries);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6802863250a706ad7c130ed443c47584", "f8ed2f67b4fa72b9973251f10df53c5d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "salaries");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `salaries`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SalaryDao.class, SalaryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SalaryDao salaryDao() {
    if (_salaryDao != null) {
      return _salaryDao;
    } else {
      synchronized(this) {
        if(_salaryDao == null) {
          _salaryDao = new SalaryDao_Impl(this);
        }
        return _salaryDao;
      }
    }
  }
}
