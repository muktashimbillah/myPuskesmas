package com.kelompok1.mypuskesmas.helper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kelompok1.mypuskesmas.menu.formData.FormInputanViewModel;
import com.kelompok1.mypuskesmas.menu.riwayatLaporan.ListLaporanViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final Application mApplication;

    private ViewModelFactory(Application application) {
        mApplication = application;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FormInputanViewModel.class)) {
            return (T) new FormInputanViewModel(mApplication);
        } else if (modelClass.isAssignableFrom(ListLaporanViewModel.class)) {
            return (T) new ListLaporanViewModel(mApplication);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
