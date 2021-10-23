package com.example.rickandmortyapp.api;


import com.example.rickandmortyapp.Model.ApiResponse;
import com.example.rickandmortyapp.Model.Characters;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetData {
    /* @GET("episode")
     Call<ApiResponse> getDataList(@Query("page") int page, @Query("pagesize") int pagesize, @Query("site") String site);
     @GET("character/{id}")
     Call<Characters> getCharacterList(@Path("id") int id , @Query("page") int page, @Query("pagesize") int pagesize, @Query("site") String site);*/
    @GET("episode")
    Call<ApiResponse> getDataList(@Query("page") Integer page);

    @GET("character/{id}")
    Call<ArrayList<Characters>> getCharacterList(@Path("id") StringBuilder ids);
}
