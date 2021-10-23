package com.example.rickandmortyapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.Model.Episodes;
import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.databinding.EpisodeRowBinding;
import com.example.rickandmortyapp.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class RcEpisodeAdapter extends RecyclerView.Adapter<RcEpisodeAdapter.MyViewHolder> {
    Context ct;
    ArrayList<Episodes> dataList;
    RecyclerViewClickListener listener;

    /* public RcEpisodeAdapter(Context ct, ArrayList<Episodes> dataList, RecyclerViewClickListener listener) {
         this.ct = ct;
         this.dataList = dataList;
     }*/
    public RcEpisodeAdapter(Context ct, ArrayList<Episodes> dataList, RecyclerViewClickListener listener) {
        this.ct = ct;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        EpisodeRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.episode_row, parent, false);
        return new RcEpisodeAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.tvName.setText(dataList.get(position).getEpname());
        holder.binding.tvEpNo.setText(dataList.get(position).getEpno());
        holder.binding.tvcreated.setText(dataList.get(position).getCreated());
        holder.binding.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * //USING PICASSO
     * void loadImage(String url, MyViewHolderThree holder)
     * {
     * Picasso.get()
     * .load(url)
     * .resize(50,50)
     * .centerCrop()
     * .placeholder(R.drawable.ic_launcher_background)
     * .error(R.drawable.ic_launcher_background)
     * .into(holder.binding.image3);
     * }
     * <p>
     * TO SHOW PROGRESS BAR WHILE LOADING IMAGE , WE USE GLIDE (BELOW)
     **/
 /*  void loadImage(String url, final MyViewHolder holder)
   { //url photos were not reached so I used diff url. You can use picasso for url.
       Glide.with(ct)
               .load("https://homepages.cae.wisc.edu/~ece533/images/airplane.png")
               .listener(new RequestListener<Drawable>() {
                   @Override
                   public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                       holder.binding.progressBar.setVisibility(View.GONE);
                       return false;
                   }

                   @Override
                   public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                       holder.binding.progressBar.setVisibility(View.GONE);
                       return false;
                   }
               })
               .into(holder.binding.image3);
   }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private EpisodeRowBinding binding;

        public MyViewHolder(EpisodeRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
