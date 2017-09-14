package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //1. Создаем listview
    private ListView listView;

    //2. Создае Адаптер
    private MyAdapter myAdapter_qazaqsha_counter;


    private MyAdapter myAdapter_russian_counter;
    private MyAdapter myAdapter_english_counter;

    //3. создаем список 1
    private List<Product> qazaqsha_counter;
    private List<Product> russian_counter;
    private List<Product> english_counter;

    //4. создаем список 2
    private List<String> list_qazaqsha_counter;
    private List<String> list_russian_counter;
    private List<String> list_english_counter;

    //реклама
    private static final String TAG = "MainActivity";
    private AdView mAdView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_qazaqsha:

                    //10. в listView добавляем адаптер
                    listView.setAdapter(myAdapter_qazaqsha_counter);

                    //14. Вызываем метод и передаем данные
                    clickitems(R.id.navigation_qazaqsha);

                    return true;
                case R.id.navigation_russian:

                    //10. в listView добавляем адаптер
                    listView.setAdapter(myAdapter_russian_counter);

                    //14. Вызываем метод и передаем данные
                    clickitems(R.id.navigation_russian);
                    return true;
                case R.id.navigation_english:


                    //10. в listView добавляем адаптер
                    listView.setAdapter(myAdapter_english_counter);

                    //14. Вызываем метод и передаем данные
                    clickitems(R.id.navigation_english);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //реклама
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //11. Вызываем метод
        qazaq();

        //12. Вызываем метод
        russian();

        //13. Вызываем метод
        english();

        //14. Вызываем метод и передаем данные
        clickitems(R.id.navigation_qazaqsha);

        //10. в listView добавляем адаптер
        listView.setAdapter(myAdapter_qazaqsha_counter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    private void clickitems(int temp) {

        //15. Принажатии вкладки будет отрабатываться соответсвующие команды
        switch (temp) {

            //16. Обработчик при нажатии qazaqsha
            case R.id.navigation_qazaqsha:

                //17. При нажатии на один из items будет выполняться код
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //18. выводим toast
                        Toast.makeText(MainActivity.this, String.valueOf(position+1), Toast.LENGTH_SHORT).show();

                        //19. Открываем новое activity и layout
                        Intent intent_qazaqsha = new Intent(getApplicationContext(), MainActivity2.class);

                        //20. Ложим туда extra
                        intent_qazaqsha.putExtra("language", R.id.navigation_qazaqsha);
                        intent_qazaqsha.putExtra("position", position);

                        //21. Запускаем
                        startActivity(intent_qazaqsha);
                    }
                });
                break;
            //16. Обработчик при нажатии russian
            case R.id.navigation_russian:

                //17. При нажатии на один из items будет выполняться код
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //18. выводим toast
                        Toast.makeText(MainActivity.this, String.valueOf(position+1), Toast.LENGTH_SHORT).show();

                        //19. Открываем новое activity и layout
                        Intent intent_russian = new Intent(getApplicationContext(), MainActivity2.class);

                        //20. Ложим туда extra
                        intent_russian.putExtra("language", R.id.navigation_russian);
                        intent_russian.putExtra("position", position);

                        //21. Запускаем
                        startActivity(intent_russian);
                    }
                });
                break;
            //16. Обработчик при нажатии english
            case R.id.navigation_english:

                //17. При нажатии на один из items будет выполняться код
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //18. выводим toast
                        Toast.makeText(MainActivity.this, String.valueOf(position+1), Toast.LENGTH_SHORT).show();

                        //19. Открываем новое activity и layout
                        Intent intent_english = new Intent(getApplicationContext(), MainActivity2.class);

                        //20. Ложим туда extra
                        intent_english.putExtra("language", R.id.navigation_english);
                        intent_english.putExtra("position", position);

                        //21. Запускаем
                        startActivity(intent_english);
                    }
                });
                break;
        }

    }


    private void qazaq() {
        //5. Инициализируем список 1
        qazaqsha_counter = new ArrayList<>();
        russian_counter = new ArrayList<>();
        english_counter = new ArrayList<>();

        //6. Инициализируем listView
        listView = (ListView) findViewById(R.id.listview_words);

        //7. В список 2 записысваем данные с array-strings которые храняться в values
        //qazaqsha
        list_qazaqsha_counter = Arrays.asList(getResources().getStringArray(R.array.qazaqsha_counter));

        //8. в список 1 добавляем обьекты Product которые содержат текст от списка 2
        for (int i = 0; i < list_qazaqsha_counter.size(); i++) {
            qazaqsha_counter.add(new Product(list_qazaqsha_counter.get(i)));
        }

        //9. Инициализируем адаптер списком 1
        myAdapter_qazaqsha_counter = new MyAdapter(getApplicationContext(), qazaqsha_counter);

    }


    private void russian() {
        //7. В список 2 записысваем данные с array-strings которые храняться в values
        //qazaqsha
        list_russian_counter = Arrays.asList(getResources().getStringArray(R.array.words_list));

        //8. в список 1 добавляем обьекты Product которые содержат текст от списка 2
        for (int i = 0; i < list_russian_counter.size(); i++) {
            russian_counter.add(new Product(list_russian_counter.get(i)));
        }

        //9. Инициализируем адаптер списком 1
        myAdapter_russian_counter = new MyAdapter(getApplicationContext(), russian_counter);
    }


    private void english() {

        //7. В список 2 записысваем данные с array-strings которые храняться в values
        //qazaqsha
        list_english_counter = Arrays.asList(getResources().getStringArray(R.array.english_counter));

        //8. в список 1 добавляем обьекты Product которые содержат текст от списка 2
        for (int i = 0; i < list_english_counter.size(); i++) {
            english_counter.add(new Product(list_english_counter.get(i)));
        }

        //9. Инициализируем адаптер списком 1
        myAdapter_english_counter = new MyAdapter(getApplicationContext(), english_counter);

    }


}
