package com.tasim.mypuskesmas.menu.riwayatLaporan.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tasim.mypuskesmas.database.entity.Bumil;
import com.tasim.mypuskesmas.databinding.ItemBumilBinding;

import java.text.DecimalFormat;
public class BumilAdapter extends ListAdapter<Bumil, BumilAdapter.MyViewHolder> {
    public BumilAdapter() {
        super(DIFF_CALLBACK);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBumilBinding binding = ItemBumilBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bumil bumil = getItem(position);
        holder.bind(bumil);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        final ItemBumilBinding binding;

        MyViewHolder(ItemBumilBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Bumil bumil) {
            binding.tvNamaBumil.setText(bumil.getNama());
            binding.tanggalLahir.setText(bumil.getTanggalLahir());
            binding.usiaKandungan.setText(bumil.getUsiaKandungan() + " minggu");
            binding.alamat.setText(bumil.getAlamat());
            DecimalFormat df = new DecimalFormat("#.#");
            binding.beratBadan.setText(df.format(bumil.getBeratBadan()) + " kg");
        }
    }

    public static final DiffUtil.ItemCallback<Bumil> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Bumil>() {
                @Override
                public boolean areItemsTheSame(@NonNull Bumil oldUser, @NonNull Bumil newUser) {
                    return oldUser.getNama().equals(newUser.getNama());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Bumil oldUser, @NonNull Bumil newUser) {
                    return oldUser.equals(newUser);
                }
            };
}
