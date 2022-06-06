package com.example.asmaulhusna_app.retrofit;

import com.example.asmaulhusna_app.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
//end point  untuk menampilkan list data asmaul Husna
    @GET("/api/asmaulHusna")
    Call<MainModel> getData();

}
