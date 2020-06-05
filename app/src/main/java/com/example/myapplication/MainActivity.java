package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<BeerList> beerLists;
    private NumbersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view();

    }

    private void view() {
        recyclerView = (RecyclerView) findViewById(R.id.tv_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BeerApi request = retrofit.create(BeerApi.class);
        Call<Beer> call = request.getBeers();
        call.enqueue(new Callback<Beer>() {
            @Override
            public void onResponse(Call<Beer> call, Response<Beer> response) {
                Beer beer = response.body();
                beerLists = new ArrayList<>(Arrays.asList(beer.getBeerLists()));
                adapter = new NumbersAdapter(beerLists);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Beer> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });


    }
}
