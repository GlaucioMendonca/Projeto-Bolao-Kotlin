package com.example.glaucio.appbolao

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var lv: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        this.lv = findViewById(R.id.lvMain)
        this.adapter()

    }

    fun adapter (){
        var dados = ArrayList<Bolao>()
        val data = SimpleDateFormat("dd-MM-yyyy").parse("20-06-2018")

        var b1 = Bolao("Brasil", "Mexico", data, 5.00, null,null)
        var b2 = Bolao("China", "Africa", data, 5.00, null,null)

        dados.add(b1)
        dados.add(b2)

        Log.e("bolao", "entrei no adapter")
        Log.e("bolao", dados[0].toString())

        this.lv.adapter = ArrayAdapter<Bolao>(this, android.R.layout.simple_list_item_1, dados)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
