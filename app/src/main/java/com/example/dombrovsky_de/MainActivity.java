package com.example.dombrovsky_de;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dombrovsky_de.network.ApiHandler;
import com.example.dombrovsky_de.network.Cats.CatsAdapter;
import com.example.dombrovsky_de.network.Cats.CatsResponce;
import com.example.dombrovsky_de.network.Cats.Data;
import com.example.dombrovsky_de.network.Cats.DataAdapter1;
import com.example.dombrovsky_de.network.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<CatsResponce> catsResponceList;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CatsAdapter catsAdapter;
    ApiService service = ApiHandler.getInstance().getService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        getCats();
    }

    private void getCats(){
        AsyncTask.execute(()->{
            service.doCats().enqueue(new Callback<Data>() {
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "1" +response.message(), Toast.LENGTH_LONG).show();

                        catsResponceList = response.body().getDoCats();
                        catsAdapter = new CatsAdapter(catsResponceList, getApplicationContext());
                        recyclerView.setAdapter(catsAdapter);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        catsAdapter.notifyDataSetChanged();

                        Toast.makeText(getApplicationContext(), "2" +response.message(), Toast.LENGTH_LONG).show();
                   } else if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"3 "+ response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Data> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Техническая" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    Log.println(Log.ERROR, "MainActivity", t.getLocalizedMessage());
                }
            });
        });
    }
}