package com.kelompok1.mypuskesmas.menu.riwayatLaporan.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok1.mypuskesmas.database.entity.Lansia;
import com.kelompok1.mypuskesmas.databinding.ItemLansiaBinding;

import java.text.DecimalFormat;
public class LansiaAdapter extends ListAdapter<Lansia, LansiaAdapter.MyViewHolder> {
    public LansiaAdapter() {
        super(DIFF_CALLBACK);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLansiaBinding binding = ItemLansiaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lansia lansia = getItem(position);
        holder.bind(lansia);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        final ItemLansiaBinding binding;

        MyViewHolder(ItemLansiaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Lansia lansia) {
            binding.tvNamaLansia.setText(lansia.getNama());
            binding.tanggalLahir.setText(lansia.getTanggalLahir());
            binding.jenisKelamin.setText(lansia.getJenisKelamin());
            binding.alamat.setText(lansia.getAlamat());
            DecimalFormat df = new DecimalFormat("#.#");
            binding.beratBadan.setText(df.format(lansia.getBeratBadan()) + " kg");
        }
    }

    public static final DiffUtil.ItemCallback<Lansia> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Lansia>() {
                @Override
                public boolean areItemsTheSame(@NonNull Lansia oldUser, @NonNull Lansia newUser) {
                    return oldUser.getNama().equals(newUser.getNama());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Lansia oldUser, @NonNull Lansia newUser) {
                    return oldUser.equals(newUser);
                }
            };
}
