package com.example.myapplication;


import retrofit2.Call;
import retrofit2.http.GET;

interface BeerApi {
    @GET("v2/beers")
    Call<Beer> getBeers();

}
