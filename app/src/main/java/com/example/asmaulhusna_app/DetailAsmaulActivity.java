package com.example.asmaulhusna_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codesgood.views.JustifiedTextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;


public class DetailAsmaulActivity extends AppCompatActivity {
    private final String TAG = "DetailAsmaulActivity";
    TextView ayat, arti;
    JustifiedTextView keterangan, meneladani;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_asmaul);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collab);
        collapsingToolbar.setExpandedTitleGravity(Gravity.BOTTOM);

        ayat = (TextView) findViewById(R.id.tv_ayat);
        arti = (TextView) findViewById(R.id.tv_arti);
        keterangan = (JustifiedTextView) findViewById(R.id.keterangan);
        meneladani = (JustifiedTextView) findViewById(R.id.meneladani);


        String ayat1 = getIntent().getStringExtra("inten_arabic");
        String latin1 = getIntent().getStringExtra("inten_latin");
        String arti1 = getIntent().getStringExtra("inten_terjemahan");
        String keterangan1 = getIntent().getStringExtra("inten_keterangan");
        String meneladani1 = getIntent().getStringExtra("inten_amalan");
//        Log.d(TAG, String.valueOf(position));
//
        collapsingToolbar.setTitle(latin1);
        ayat.setText(ayat1);
        arti.setText(arti1);
        keterangan.setText(keterangan1);
        meneladani.setText(meneladani1);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}