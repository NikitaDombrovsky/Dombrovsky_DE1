package com.example.dombrovsky_de;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dombrovsky_de.network.ApiHandler;
import com.example.dombrovsky_de.network.Cats.CatsAdapter;
import com.example.dombrovsky_de.network.Cats.CatsResponce;
import com.example.dombrovsky_de.network.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ArrayList<CatsAdapter> catsAdapters;
    private ArrayList<CatsResponce> catsResponces;
    //CatsAdapter catsAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CatsAdapter catsAdapter;
    //List<CatsResponce> catsResponces;
    ApiService service = ApiHandler.getInstance().getService();
   // RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyplerView);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        getCats();
    }
    private void getCats(){
        AsyncTask.execute(()->{
            service.doCats().enqueue(new Callback<List<CatsResponce>>() {
                @Override
                public void onResponse(Call<List<CatsResponce>> call, Response<List<CatsResponce>> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Харош" +response.message(), Toast.LENGTH_LONG).show();
                        catsResponces = new ArrayList<>(response.body());
                        catsAdapter = new CatsAdapter(catsResponces, getApplicationContext());
                        recyclerView.setAdapter(catsAdapter);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        catsAdapter.notifyDataSetChanged();
                       // recyclerView.setAdapter(catsAdapter);
                    } else if (response.code() == 400) {
//                        Log.d(TAG, serverErrorMessage.toString() + " || " + response.code());
//                        Log.d(getApplicationContext(),"Техническая" );
                        Toast.makeText(getApplicationContext(),"1 "+ response.message(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"2 "+ response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<CatsResponce>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Техническая" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    Log.println(Log.ERROR, "MainActivity", t.getLocalizedMessage());
                }
            });
        });
//    private void getCats(){
//        AsyncTask.execute(()->{
//            service.doCats().enqueue(new Callback<CatsResponce>() {
//                @Override
//                public void onResponse(Call<CatsResponce> call, Response<CatsResponce> response) {
//                    if (response.isSuccessful()){
//                        Toast.makeText(getApplicationContext(), "Харош" +response.message(), Toast.LENGTH_LONG).show();
//                        catsResponces = new ArrayList<>(response.body());
//                        catsAdapter = new CatsAdapter(catsResponces, getApplicationContext());
//                        recyclerView.setAdapter(catsAdapter);
//                        recyclerView.setLayoutManager(linearLayoutManager);
//                        catsAdapter.notifyDataSetChanged();
//                       // recyclerView.setAdapter(catsAdapter);
//                    } else if (response.code() == 400) {
////                        Log.d(TAG, serverErrorMessage.toString() + " || " + response.code());
////                        Log.d(getApplicationContext(),"Техническая" );
//                        Toast.makeText(getApplicationContext(),"1 "+ response.message(), Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(),"2 "+ response.message(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//                @Override
//                public void onFailure(Call<CatsResponce> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), "Техническая" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                    Log.println(Log.ERROR, "MainActivity", t.getLocalizedMessage());
//                }
//            });
//        });

    }
}