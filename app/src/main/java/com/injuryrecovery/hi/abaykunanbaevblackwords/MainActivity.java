package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private String kazakh = "";
    private String russian = "";
    private String english = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kazakh = getResources().getString(R.string.kazakh);
        russian = getResources().getString(R.string.russian);
        english = getResources().getString(R.string.english);
        Log.i("autolog", "english: " + english);

        //реклама
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView = findViewById(R.id.listview_words);
        listView.setAdapter(getAdapter(kazakh));

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        clickedItems(kazakh);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_qazaqsha:
                    clickedItems(kazakh);
                    return true;
                case R.id.navigation_russian:
                    clickedItems(russian);
                    return true;
                case R.id.navigation_english:
                    clickedItems(english);
                    return true;
            }
            return false;
        }
    };

    //Будет открываться в новой Activity черные слова по clicked blackword
    private void clickedItems(final String language) {
        listView.setAdapter(getAdapter(language));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(position + 1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("language", language);
                Log.i("autolog", "language intent: " + language);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }


    private MyAdapter getAdapter(String language) {

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        List<String> listItems = databaseAccess.getItems(language);
        List<Product> items = new ArrayList<>();

        for (int i = 0; i < listItems.size(); i++) {
            items.add(new Product(listItems.get(i)));
        }

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),items);
        databaseAccess.close();

        return myAdapter;
    }


}
