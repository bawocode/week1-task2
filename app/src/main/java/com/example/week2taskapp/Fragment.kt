 package com.example.week2taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

 class Fragment : AppCompatActivity() {

     var counter = 0
     private lateinit var stackDisplay: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        val bar = supportActionBar
        bar!!.title = "ActivityTwo"
        bar.setDisplayHomeAsUpEnabled(true)
        stackDisplay = findViewById(R.id.stackDisplay)

    }
     fun increased(view:View){
         counter ++
         stackDisplay.text = "Current Stack : " + counter
     }

     fun decreased(view: View){
         if (counter == 0){
            stackDisplay.text = "Current Stack : " + counter
         } else{
             counter--
             stackDisplay.text = "Current Stack : " + counter
         }
     }

}
