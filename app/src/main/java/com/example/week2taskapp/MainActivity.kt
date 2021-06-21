package com.example.week2taskapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.week2taskapp.R.id.buttonSwitch

class MainActivity : AppCompatActivity() {
    private lateinit var firstTextView: TextView
    private lateinit var secondTextView: TextView
    private var portraitCounter = 1
    private var landscapeCounter = 0
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myButton = findViewById<Button>(R.id.buttonSwitch)
        myButton.setOnClickListener{
            intent = Intent(this, Fragment::class.java)
            startActivity(intent)
        }

        firstTextView = findViewById(R.id.firstTextView)
        secondTextView = findViewById(R.id.secondTextView)

        handler.postDelayed({firstTextView.text = "ON CREATE"} , 1000)

        secondTextView.text = "Portrait Counter ${portraitCounter}"
        if (savedInstanceState != null){
            portraitCounter = savedInstanceState.getInt("portraitCount")
            landscapeCounter = savedInstanceState.getInt("landscapeCount")

            var orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                landscapeCounter++
                secondTextView.text = "Landscape Counter ${landscapeCounter}"
            }
            else if (orientation == Configuration.ORIENTATION_PORTRAIT){
                portraitCounter++
                secondTextView.text = "Potrait Counter ${portraitCounter}"
            }
        }


    }

        override fun onStart() {
            super.onStart()
            print("onStart")
            handler.postDelayed( {firstTextView.text = "ON START"}, 1000)
        }

        override fun onResume() {
            super.onResume()
            print("onResume")
            handler.postDelayed({firstTextView.text = "ON RESUME"} , 1200)

        }

        override fun onPause() {
            super.onPause()
            print("onPause")
            handler.postDelayed({firstTextView.text = "ON PAUSE"} , 1500)

        }

        override fun onStop() {
            super.onStop()
            print("onStop")
            handler.postDelayed({firstTextView.text = "ON STOP"} , 1000)
        }

        override fun onRestart() {
            super.onRestart()
            print("onRestart")
            handler.postDelayed({firstTextView.text = "ON RESTART"} , 1200)
        }

        override fun onDestroy() {
            super.onDestroy()
            print("onDestroy")
            handler.postDelayed({firstTextView.text = "ON DESTROY"} , 1000)
        }

        private fun print(msg: String){
            Log.i("Activity State ",msg)
        }


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("portraitCount", portraitCounter)
        savedInstanceState.putInt("landscapeCount", landscapeCounter)
        super.onSaveInstanceState(savedInstanceState)
    }
}


