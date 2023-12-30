package com.kelompok1.mypuskesmas.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kelompok1.mypuskesmas.database.entity.Balita;

import java.util.List;

@Dao
public interface BalitaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Balita balita);

    @Update()
    void update(Balita balita);

    @Delete()
    void delete(Balita balita);
    @Query("SELECT * from balita ORDER BY id ASC")
    LiveData<List<Balita>> getAllBalita();
}
