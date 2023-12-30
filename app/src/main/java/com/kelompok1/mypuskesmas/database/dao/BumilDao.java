package com.kelompok1.mypuskesmas.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kelompok1.mypuskesmas.database.entity.Bumil;

import java.util.List;

@Dao
public interface BumilDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Bumil bumil);
    @Update()
    void update(Bumil bumil);
    @Delete()
    void delete(Bumil bumil);
    @Query("SELECT * from bumil ORDER BY id ASC")
    LiveData<List<Bumil>> getAllBumil();
}