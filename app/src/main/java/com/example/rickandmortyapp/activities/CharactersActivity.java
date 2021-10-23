package com.example.rickandmortyapp.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.rickandmortyapp.Model.Characters;
import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.adapters.RcCharacterAdapter;
import com.example.rickandmortyapp.api.ApiClient;
import com.example.rickandmortyapp.api.GetData;
import com.example.rickandmortyapp.databinding.ActivityCharactersBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersActivity extends Activity {
    private ActivityCharactersBinding binding;
    private ProgressDialog progressDialog;
    private RcCharacterAdapter adapter;
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<Characters> characters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_characters);
        getIntentData();
        getServerData();

    }

    private void getIntentData() {
        if (getIntent() != null) {

            if (getIntent().getSerializableExtra("data") != null) {
                ids = (ArrayList<String>) getIntent().getSerializableExtra("data");
            }
        }
    }

    void getServerData() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            id.append("," + ids.get(i));
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        GetData getDataService = ApiClient.getRetrofitInstance().create(GetData.class);
        Call<ArrayList<Characters>> call = getDataService.getCharacterList(id);
        call.enqueue(new Callback<ArrayList<Characters>>() {
            @Override
            public void onResponse(Call<ArrayList<Characters>> call, Response<ArrayList<Characters>> response) {
                progressDialog.dismiss();
                characters.clear();
                characters.addAll(response.body());
                showData();
            }

            @Override
            public void onFailure(Call<ArrayList<Characters>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CharactersActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }


        });
    }

    void showData() {
        adapter = new RcCharacterAdapter(this, characters);
        binding.rcViewCh.setAdapter(adapter);


 /*adapter=new AdapterFour(this,arrayList, new RecyclerViewClickListener() {
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

