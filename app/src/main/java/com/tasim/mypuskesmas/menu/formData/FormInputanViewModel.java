package com.tasim.mypuskesmas.menu.formData;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.tasim.mypuskesmas.database.entity.Balita;
import com.tasim.mypuskesmas.database.entity.Bumil;
import com.tasim.mypuskesmas.database.entity.Lansia;
import com.tasim.mypuskesmas.repository.PuskesmasRepository;

public class FormInputanViewModel extends ViewModel {
    private final PuskesmasRepository mPuskesmasRepository;

    public FormInputanViewModel(Application application) {
        mPuskesmasRepository = new PuskesmasRepository(application);
    }

    public void insert(Balita balita) {
        mPuskesmasRepository.insert(balita);
    }

    public void insertBumil(Bumil bumil) {
        mPuskesmasRepository.insertBumil(bumil);
    }
    public void insertLansia(Lansia lansia) {
        mPuskesmasRepository.insertLansia(lansia);
    }

    public void update(Balita balita) {
        mPuskesmasRepository.update(balita);
    }

    public void delete(Balita balita) {
        mPuskesmasRepository.delete(balita);
    }
}
