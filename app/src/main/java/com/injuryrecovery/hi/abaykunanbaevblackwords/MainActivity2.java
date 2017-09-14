package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvText;


    private List<String> list_qazaqsha_counter;
    private List<String> list_russian_counter;
    private List<String> list_english_counter;

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

        list_qazaqsha_counter = Arrays.asList(getResources().getStringArray(R.array.words_qazaqsha));
        list_russian_counter = Arrays.asList(getResources().getStringArray(R.array.words_russian));
        list_english_counter = Arrays.asList(getResources().getStringArray(R.array.words_english));

        mTvText = (TextView) findViewById(R.id.tvText);



        Intent mIntent = getIntent();
        int language = mIntent.getIntExtra("language", 0);
        int position = mIntent.getIntExtra("position", 0);


        switch (language) {

            case R.id.navigation_qazaqsha:
                mTvText.setText(list_qazaqsha_counter.get(position));
                break;
            case R.id.navigation_russian:
                mTvText.setText(list_russian_counter.get(position));
                break;
            case R.id.navigation_english:
                mTvText.setText(list_english_counter.get(position));
                break;
        }


    }


}
