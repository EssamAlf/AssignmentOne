package com.example.temperatureconverter

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.util.Log;

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    val TAG = "My message"

    fun convertTemperature(view: View) {
        if (temperatureText.text.isNotEmpty()) {
            val tempValue = temperatureText.text.toString().toFloat()


            val celValue = (tempValue *1.8) +32
            textView.text = celValue.toString()
        } else {
            textView.text = getString(R.string.no_value_string)
        }

    }

    fun convertCelsius(view: View) {
        if (editText.text.isNotEmpty()) {
            val celsiusValue = editText.text.toString().toFloat()


            val FahValue = (celsiusValue -32) *5/9
            textView.text = FahValue.toString()
        } else {
            textView.text = getString(R.string.no_celsius_string)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
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
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i(TAG,"onSaveInstanceState")

        val userText=editText.text
        outState?.putCharSequence("savedText",userText)

    }
    override fun onRestoreInstanceState(savedInstanceState:Bundle?){
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG,"onRestoreInstanceState")

        val userText=savedInstanceState?.getCharSequence("savedText")
        editText.setText(userText)
    }


}
