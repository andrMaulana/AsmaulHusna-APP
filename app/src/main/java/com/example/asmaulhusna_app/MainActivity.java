package com.example.asmaulhusna_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asmaulhusna_app.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private MainAdapter mainAdapter;
    private List<MainModel.Data> datas = new ArrayList<>();

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupRecyclerView();
        getDataFromApi();

    }

    private void setupView(){
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecyclerView(){
        mainAdapter = new MainAdapter(datas, new MainAdapter.OnAdapterListener() {
            @Override
            public void OnClick(MainModel.Data data) {
//                Toast.makeText(MainActivity.this, data.getLatin(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailAsmaulActivity.class);
                intent.putExtra("inten_id", data.getId());
                intent.putExtra("inten_arabic", data.getArabic());
                intent.putExtra("inten_latin", data.getLatin());
                intent.putExtra("inten_terjemahan", data.getTerjemahan());
                intent.putExtra("inten_keterangan", data.getKeterangan());
                intent.putExtra("inten_amalan", data.getAmalan());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter( mainAdapter );
    }

    private void getDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getData()
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful()){
                            List<MainModel.Data> datas = response.body().getData();
                            Log.d(TAG, datas.toString());
                            mainAdapter.setData( datas );
                        }

                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Log.d(TAG, t.toString());

                    }
                });

    }
}