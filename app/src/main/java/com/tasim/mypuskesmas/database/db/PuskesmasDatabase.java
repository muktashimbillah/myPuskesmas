package com.tasim.mypuskesmas.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tasim.mypuskesmas.database.dao.BalitaDao;
import com.tasim.mypuskesmas.database.dao.BumilDao;
import com.tasim.mypuskesmas.database.dao.LansiaDao;
import com.tasim.mypuskesmas.database.entity.Balita;
import com.tasim.mypuskesmas.database.entity.Bumil;
import com.tasim.mypuskesmas.database.entity.Lansia;

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
