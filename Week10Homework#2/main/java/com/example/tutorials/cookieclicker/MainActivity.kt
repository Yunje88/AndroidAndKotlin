package com.example.tutorials.cookieclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var currentScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgCookie: ImageView = findViewById(R.id.imgCookie)
        val lblTotal: TextView = findViewById(R.id.lblTotal)

        imgCookie.setOnClickListener{
            currentScore ++
            lblTotal.text = "$currentScore"
        }
    }
}