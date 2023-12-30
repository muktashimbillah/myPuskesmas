package com.kelompok1.mypuskesmas.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kelompok1.mypuskesmas.database.entity.Lansia;

import java.util.List;
@Dao
public interface LansiaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Lansia lansia);

    @Update()
    void update(Lansia lansia);

    @Delete()
    void delete(Lansia lansia);
    @Query("SELECT * from lansia ORDER BY id ASC")
    LiveData<List<Lansia>> getAllLansia();
}
