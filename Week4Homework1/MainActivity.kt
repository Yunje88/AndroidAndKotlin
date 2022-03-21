package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //global variable
    private var mBinding: ActivityMainBinding? = null

    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Retrieve.setOnClickListener{

            binding.tvMessage.setText("External files are stored at " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())


        }


    }
}