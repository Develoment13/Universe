package com.development.hybrid.universe.api;

import com.development.hybrid.universe.ui.apod.model.APODModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceNASA {

    @GET("apod")
    Call<APODModel> getApodData(@Query("api_key") String API_KEY);

}
