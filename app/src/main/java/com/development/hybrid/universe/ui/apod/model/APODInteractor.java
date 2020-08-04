package com.development.hybrid.universe.ui.apod.model;

import androidx.annotation.NonNull;

import com.development.hybrid.universe.BuildConfig;
import com.development.hybrid.universe.api.ApiServiceNASA;
import com.development.hybrid.universe.ui.apod.interfaces.APODInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APODInteractor implements APODInterface.interactor {

    @Override
    public void onRemoteFetch(APODInterface.presenter listener) {
        String BASE_URL = "https://api.nasa.gov/planetary/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServiceNASA service = retrofit.create(ApiServiceNASA.class);

        service.getApodData(BuildConfig.API_KEY)
                .enqueue(new Callback<APODModel>() {
                    @Override
                    public void onResponse(@NonNull Call<APODModel> call, @NonNull Response<APODModel> response) {
                        if (!response.isSuccessful()){
                            listener.onFailure("Connection error. Try again!");
                            return;
                        }
                        APODModel apodModel = response.body();
                        if (apodModel != null){
                            listener.onSuccess(apodModel);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<APODModel> call, @NonNull Throwable t) {
                        listener.onFailure(t.getMessage());
                    }
                });
    }

}
