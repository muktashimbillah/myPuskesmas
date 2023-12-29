package com.tasim.mypuskesmas.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tasim.mypuskesmas.database.dao.BalitaDao;
import com.tasim.mypuskesmas.database.dao.BumilDao;
import com.tasim.mypuskesmas.database.dao.LansiaDao;
import com.tasim.mypuskesmas.database.db.PuskesmasDatabase;
import com.tasim.mypuskesmas.database.entity.Balita;
import com.tasim.mypuskesmas.database.entity.Bumil;
import com.tasim.mypuskesmas.database.entity.Lansia;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PuskesmasRepository {
    private final BalitaDao mBalitaDao;
    private final BumilDao mBumilDao;
    private final LansiaDao mLansiaDao;
    private final ExecutorService executorService;

    public PuskesmasRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        PuskesmasDatabase db = PuskesmasDatabase.getDatabase(application);
        mBalitaDao = db.balitaDao();
        mBumilDao = db.bumilDao();
        mLansiaDao = db.lansiaDao();
    }
    public LiveData<List<Balita>> getAllBalita() {
        return mBalitaDao.getAllBalita();
    }
    public LiveData<List<Bumil>> getAllBumil() {
        return mBumilDao.getAllBumil();
    }

    public LiveData<List<Lansia>> getAllLansia() {
        return mLansiaDao.getAllLansia();
    }
    public void insertBumil(final Bumil bumil) {
        executorService.execute(() -> mBumilDao.insert(bumil));
    }

    public void insertLansia(final Lansia lansia) {
        executorService.execute(() -> mLansiaDao.insert(lansia));
    }
    public void insert(final Balita balita) {
        executorService.execute(() -> mBalitaDao.insert(balita));
    }

    public void update(final Balita balita) {
        executorService.execute(() -> mBalitaDao.update(balita));
    }

    public void delete(final Balita balita) {
        executorService.execute(() -> mBalitaDao.delete(balita));
    }
}
