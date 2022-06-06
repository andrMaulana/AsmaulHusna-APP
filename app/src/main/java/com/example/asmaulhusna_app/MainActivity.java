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
//    menjalankan beberapa method yang pertama kali di tampilkan
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
//            method untuk on klik beberapa card yang ada di adapter
            public void OnClick(MainModel.Data data) {
//                Inten atau activiti mana yang di tuju ketika di klok
                Intent intent = new Intent(MainActivity.this, DetailAsmaulActivity.class);
//                mengambil beberapa data pada activity sebelumnya
                intent.putExtra("inten_id", data.getId());
                intent.putExtra("inten_arabic", data.getArabic());
                intent.putExtra("inten_latin", data.getLatin());
                intent.putExtra("inten_terjemahan", data.getTerjemahan());
                intent.putExtra("inten_keterangan", data.getKeterangan());
                intent.putExtra("inten_amalan", data.getAmalan());
//                mengarah aktivity yang di tuju
                startActivity(intent);
            }
        });
//        Set untuk Recycler adapternya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter( mainAdapter );
    }

//    method untuk menampilkan data Asmaul Husna
    private void getDataFromApi(){
//        progress ketika data dimuat
        progressBar.setVisibility(View.VISIBLE);
//        memanggil endpoit data yang akan di ambil berdasarkan model nya
        ApiService.endpoint().getData()
                .enqueue(new Callback<MainModel>() {
                    @Override
//                    memanggil respon data apabila data tersedia
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
//                        progress apabila data berhasil di ambil maka progress akan berhenti
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful()){
//                            setelah progress berhenti data akan di tampilkan
                            List<MainModel.Data> datas = response.body().getData();
                            Log.d(TAG, datas.toString());
//                            menampilkan data pada class adapter
                            mainAdapter.setData( datas );
                        }

                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
//                        progress bar juga akan berhenti apabila data gagal di tampilkan
                        Log.d(TAG, t.toString());

                    }
                });

    }
}