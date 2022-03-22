package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val databaseHelper: DatabaseHelper by lazy {
        DatabaseHelper.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertDb()
        deleteDb()
        getAllDb()

    }

    override fun onDestroy(){
        databaseHelper.close()
        super.onDestroy()
    }

    private fun showTxt(text: String){
        binding.tvInfo.append(text + "\n")
    }

    private fun clearEditTexts(){
        with(binding){
            etUid.setText("")
            etFname.setText("")
            etLname.setText("")
            etReward.setText("")
        }
    }

    private fun insertDb(){

        clearEditTexts()
        binding.btnAdd.setOnClickListener{
            try{
                databaseHelper.insertData(
                    binding.etFname.text.toString().trim(),
                    binding.etLname.text.toString().trim(),
                    binding.etReward.text.toString().trim()
                )
                clearEditTexts()
                showTxt("Data inserted")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    private fun deleteDb(){

        clearEditTexts()
        binding.btnDelete.setOnClickListener{
            try{
                databaseHelper.deleteData(binding.etUid.text.toString().trim())
                clearEditTexts()
                showTxt("Data inserted")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getAllDb(){

        clearEditTexts()
        binding.btnInfo.setOnClickListener{
            try{
                val selectResult : String = databaseHelper.getAllData()
                showTxt(selectResult)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

}
