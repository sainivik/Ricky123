package com.example.rickandmortyapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.Model.Characters;
import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.databinding.CharactersRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class RcCharacterAdapter extends RecyclerView.Adapter<RcCharacterAdapter.MyViewHolderTwo> {
    Context ct;
    ArrayList<Characters> dataList;

    public RcCharacterAdapter(Context ct, ArrayList<Characters> dataList) {
        this.ct = ct;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CharactersRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.characters_row, parent, false);
        return new MyViewHolderTwo(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTwo holder, int position) {
        //     holder.binding.image3.setImageBitmap(getBitmapFromURL(dataList.get(position).getImageUrl()));

        /*Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/Creative.ttf");
        holder.binding.tvNameCh.setTypeface(tf);*/
        holder.binding.tvNameCh.setText(dataList.get(position).getChname());
        holder.binding.tvstatus.setText(dataList.get(position).getStatus());
        holder.binding.tvspecies.setText(dataList.get(position).getSpecies());
        holder.binding.tvGender.setText(dataList.get(position).getGender());
        holder.binding.tvlocation.setText(dataList.get(position).getLocation().getLocationname());
        Picasso.get()
                .load(dataList.get(position).getImageurl())
                .resize(130, 130)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.error_image)
                .into(holder.binding.ivCharacter);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class MyViewHolderTwo extends RecyclerView.ViewHolder {
        private CharactersRowBinding binding;

        public MyViewHolderTwo(CharactersRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
