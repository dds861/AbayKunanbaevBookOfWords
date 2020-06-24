package com.injuryrecovery.hi.abaykunanbaevblackwords

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.util.*

class LanguagesActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    private var tableName = ""
    private lateinit var legalText: TextView
    private var mActionBarToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)


//        mActionBarToolbar = findViewById<View>(R.id.toolbar_actionbar) as Toolbar
//        setSupportActionBar(mActionBarToolbar)
//        supportActionBar!!.title = resources.getString(R.string.app_name_kazakh)

        tableName = resources.getString(R.string.languages)


        //реклама
//        val mAdView = findViewById<AdView>(R.id.adView)
//        val adRequest = AdRequest.Builder().build()
//        mAdView.loadAd(adRequest)

        listView = findViewById(R.id.listview_words)
        listView.adapter = getAdapter(tableName)

//        supportActionBar!!.title = resources.getString(R.string.app_name_kazakh)
//        legalText.visibility = View.GONE

        clickedItems(tableName)
    }

    //Будет открываться в новой Activity черные слова по clicked blackword
    private fun clickedItems(language: String) {
        listView.adapter = getAdapter(language)
        listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, (position + 1).toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, BlackWordNumsActivity::class.java)
            intent.putExtra("language", language)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }


    private fun getAdapter(tableName: String): MyAdapter? {
        val databaseAccess = DatabaseAccess.getInstance(this)
        databaseAccess.open()
        val listItems = databaseAccess.getLanguages(tableName)
        val items: MutableList<Product> = ArrayList()
        for (i in listItems.indices) {
            items.add(Product(listItems[i]))
        }
        val myAdapter = MyAdapter(applicationContext, items)
        databaseAccess.close()
        return myAdapter
    }


}