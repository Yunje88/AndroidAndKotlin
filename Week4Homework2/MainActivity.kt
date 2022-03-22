package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class MainActivity : AppCompatActivity() {

    private val EXTERNAL_STORAGE_PERMISSION_CODE = 23

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var textView: TextView? = null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getName()

    }

    private  fun showTxt(text: String){
        binding.tvInfo.append(text + "\n")
    }

    private fun getName(){

         val db = DBHelper(this,null)

        binding.btnCheck.setOnClickListener{
            try{

                val selectResult : String = db.getName()
                showTxt(selectResult)
            } catch (e: java.lang.Exception){
                e.printStackTrace()
            }
        }
    }

    fun showData(){
        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        val file = File(folder,"100-contacts.xlsx")
        val data = getdata(file)
        if(data != null){
            textView!!.text=data
        } else {
            textView!!.text = "No Data Found"
        }

    }

    private fun getdata(myfile: File): String?{
        var inputString = ""

        val bufferedReader: BufferedReader = myfile.bufferedReader()

        inputString = bufferedReader.use { it.readText() }

        return inputString
    }


}