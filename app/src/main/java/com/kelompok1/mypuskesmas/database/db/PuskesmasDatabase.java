package com.kelompok1.mypuskesmas.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kelompok1.mypuskesmas.database.dao.BalitaDao;
import com.kelompok1.mypuskesmas.database.dao.BumilDao;
import com.kelompok1.mypuskesmas.database.dao.LansiaDao;
import com.kelompok1.mypuskesmas.database.entity.Balita;
import com.kelompok1.mypuskesmas.database.entity.Bumil;
import com.kelompok1.mypuskesmas.database.entity.Lansia;

@Database(entities = {Balita.class, Bumil.class, Lansia.class}, version = 1, exportSchema = false)
public abstract class PuskesmasDatabase extends RoomDatabase {
    public abstract BalitaDao balitaDao();
    public abstract BumilDao bumilDao();
    public abstract LansiaDao lansiaDao();

    private static volatile PuskesmasDatabase INSTANCE;

    public static PuskesmasDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PuskesmasDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PuskesmasDatabase.class, "puskesmas_database")
                        .build();
            }
        }
        return INSTANCE;
    }
}
