package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BlackWordNumsActivity extends AppCompatActivity {

    private ListView listView;

    private String kazakh = "";
    private String russian = "";
    private String english = "";
    private String portuguese = "";
    private TextView legaText;
    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_word_num);


        legaText = findViewById(R.id.tvLegalText);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name_kazakh));

        kazakh = getResources().getString(R.string.kazakh);
        russian = getResources().getString(R.string.russian);
        english = getResources().getString(R.string.english);
        portuguese = getResources().getString(R.string.portuguese);

        //реклама
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView = findViewById(R.id.listview_words);
        listView.setAdapter(getAdapter(kazakh));

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent mIntent = getIntent();
        String language = mIntent.getStringExtra("language");
        int position = mIntent.getIntExtra("position", 0);
        Log.i("autolog", "position: " + position);

        String selectedLanguage = getLanguageByPosition(String.valueOf(position+1));
        clickedItems(selectedLanguage);
    }

    private String getLanguageByPosition(String position) {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        return databaseAccess.getLanguageByPosition(position);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_qazaqsha:
                    getSupportActionBar().setTitle(getResources().getString(R.string.app_name_kazakh));
                    legaText.setVisibility(View.GONE);
                    clickedItems(kazakh);
                    return true;
                case R.id.navigation_russian:
                    getSupportActionBar().setTitle(getResources().getString(R.string.app_name_russian));
                    legaText.setVisibility(View.GONE);
                    clickedItems(russian);
                    return true;
                case R.id.navigation_english:
                    getSupportActionBar().setTitle(getResources().getString(R.string.app_name_english));
                    legaText.setVisibility(View.GONE);
                    clickedItems(english);
                    return true;
                case R.id.navigation_portuguese:
                    getSupportActionBar().setTitle(getResources().getString(R.string.app_name_portuguese));
                    legaText.setVisibility(View.VISIBLE);
                    clickedItems(portuguese);
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
                Toast.makeText(BlackWordNumsActivity.this, String.valueOf(position + 1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), BlackWordTextActivity.class);
                intent.putExtra("language", language);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }


    private MyAdapter getAdapter(String language) {

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        List<String> listItems = databaseAccess.getNumBlackWord(language);
        List<Product> items = new ArrayList<>();

        for (int i = 0; i < listItems.size(); i++) {
            items.add(new Product(listItems.get(i)));
        }

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), items);
        databaseAccess.close();

        return myAdapter;
    }


}
