package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    //реклама
    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //реклама
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent mIntent = getIntent();
        String language = mIntent.getStringExtra("language");
        Log.i("autolog", "language: " + language);
        int position = mIntent.getIntExtra("position", 0);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        List<String> list_qazaqsha_counter = databaseAccess.getBlackWord(language);

        TextView mTvText = (TextView) findViewById(R.id.tvText);

        String s1 = list_qazaqsha_counter.get(position);
        s1=s1.replaceAll("\\\\n","\n");
        s1=s1.replaceAll("\\\\t","\t");
        mTvText.setText(s1);
    }
}
