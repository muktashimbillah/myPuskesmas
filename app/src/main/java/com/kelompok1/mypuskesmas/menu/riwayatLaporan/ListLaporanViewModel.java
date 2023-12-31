package com.kelompok1.mypuskesmas.menu.riwayatLaporan;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kelompok1.mypuskesmas.database.entity.Balita;
import com.kelompok1.mypuskesmas.database.entity.Bumil;
import com.kelompok1.mypuskesmas.database.entity.Lansia;
import com.kelompok1.mypuskesmas.repository.PuskesmasRepository;

import java.util.List;

public class ListLaporanViewModel extends ViewModel {
    private final PuskesmasRepository mPuskesmasRepository;

    public ListLaporanViewModel(Application application) {
        mPuskesmasRepository = new PuskesmasRepository(application);
    }
    LiveData<List<Balita>>getAllBalita() {
        return mPuskesmasRepository.getAllBalita();
    }

    LiveData<List<Bumil>>getAllBumil() {
        return mPuskesmasRepository.getAllBumil();
    }

    LiveData<List<Lansia>>getAllLansia() {
        return mPuskesmasRepository.getAllLansia();
    }
}
