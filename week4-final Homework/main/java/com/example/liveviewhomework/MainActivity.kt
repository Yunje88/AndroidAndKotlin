package com.example.liveviewhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.liveviewhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding = ActivityMainBinding

    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myNumberViewModel = ViewModelProvider(this).get(myNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {

        binding.equalTo.setOnClickListener(this)

        })
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
        val userFirstInput = binding.firstValue.text.toString().toInt()
        val userSecondInput = binding.secondvalue.text.toString().toInt()
        val result = userFirstInput * userSecondInput

        myNumberViewModel.updateValue(result)

    }
}