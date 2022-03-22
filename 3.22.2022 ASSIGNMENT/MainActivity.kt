package com.example.simpletable

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simpletable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveData()
    }

    fun saveData(){
        binding.btnSubmit.setOnClickListener{
            val db = DBHelper(this, null)
            val userdata = binding.etData.text.toString()
            db.addData(userdata)
            Toast.makeText(this, "${userdata} is added", Toast.LENGTH_LONG).show()
            binding.etData.text.clear()
        }
    }
}