package com.tasim.mypuskesmas.menu.riwayatLaporan.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tasim.mypuskesmas.database.entity.Balita;
import com.tasim.mypuskesmas.databinding.ItemBalitaBinding;

import java.text.DecimalFormat;
public class BalitaAdapter extends ListAdapter<Balita, BalitaAdapter.MyViewHolder> {
    public BalitaAdapter() {
        super(DIFF_CALLBACK);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBalitaBinding binding = ItemBalitaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Balita bumil = getItem(position);
        holder.bind(bumil);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        final ItemBalitaBinding binding;

        MyViewHolder(ItemBalitaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Balita balita) {
            binding.tvNamaBalita.setText(balita.getNama());
            binding.tanggalLahir.setText(balita.getTanggalLahir());
            binding.jenisKelamin.setText(balita.getJenisKelamin());
            binding.alamat.setText(balita.getAlamat());
            DecimalFormat df = new DecimalFormat("#.#");
            binding.beratBadan.setText(df.format(balita.getBeratBadan()) + " kg");
        }
    }

    public static final DiffUtil.ItemCallback<Balita> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Balita>() {
                @Override
                public boolean areItemsTheSame(@NonNull Balita oldUser, @NonNull Balita newUser) {
                    return oldUser.getNama().equals(newUser.getNama());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Balita oldUser, @NonNull Balita newUser) {
                    return oldUser.equals(newUser);
                }
            };
}


