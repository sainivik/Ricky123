package com.example.rickandmortyapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rickandmortyapp.Model.ApiResponse;
import com.example.rickandmortyapp.Model.Episodes;
import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.adapters.RcEpisodeAdapter;
import com.example.rickandmortyapp.api.ApiClient;
import com.example.rickandmortyapp.api.GetData;
import com.example.rickandmortyapp.databinding.ActivityEpisodeBinding;
import com.example.rickandmortyapp.endless_recyclerview.EndlessRecyclerViewScrollListener;
import com.example.rickandmortyapp.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeActivity extends AppCompatActivity {
    private ActivityEpisodeBinding binding;
    private ProgressDialog progressDialog;
    private RcEpisodeAdapter adapter;
    private ArrayList<Episodes> episodes = new ArrayList();
    private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    private int maxCount = 1;
    private int currentPage = 1;
    private int startPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_episode);
        // getServerData();
       /* StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append("," + );
        }*/
        showData();
        getServerData();
        setEndLessRecyclerView();

    }

    private void setEndLessRecyclerView() {

        endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener((LinearLayoutManager) binding.rcView.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                // if (connection.isInternetConnected()) {
                Log.e("current--   max--", "" + currentPage + "--  " + maxCount);
                if (currentPage <= maxCount) {

                    getServerData();
                }
                // }
            }
        };
        binding.rcView.addOnScrollListener(endlessRecyclerViewScrollListener);
    }


    void getServerData() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        GetData getDataService = ApiClient.getRetrofitInstance().create(GetData.class);
        Call<ApiResponse> call = getDataService.getDataList(currentPage);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                progressDialog.dismiss();
                if (currentPage == 1) {
                    episodes.clear();
                }
                maxCount = response.body().getInfo().getPages();
                currentPage = currentPage + 1;
                episodes.addAll(response.body().getEpisodes());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EpisodeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void showData() {
        adapter = new RcEpisodeAdapter(this, episodes, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int pos) {
                ArrayList<String> ids = new ArrayList<>();
                for (int i = 0; i < episodes.get(pos).getCharactersurl().size(); i++) {
                    ids.add(episodes.get(pos).getCharactersurl().get(i).replace("https://rickandmortyapi.com/api/character/", ""));

                }
                Intent intent = new Intent(EpisodeActivity.this, CharactersActivity.class);
                intent.putExtra("data", ids);
                startActivity(intent);
            }
        });
        binding.rcView.setAdapter(adapter);


       /* adapter=new AdapterFour(this,arrayList, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int pos) {
                switch (view.getId()) {
                    case R.id.locate_btn: {
                        Intent i = new Intent(DesignFourActivity.this, LocationActivity.class);
                        i.putExtra("lat_value",Double.valueOf(arrayList.get(pos).getAddress().getGeo().getLat()));
                        i.putExtra("lng_value",Double.valueOf(arrayList.get(pos).getAddress().getGeo().getLng()));
                        startActivity(i);
                    }
                }
            }
        });
        binding.rcView4.setAdapter(adapter);*/
    }
}
