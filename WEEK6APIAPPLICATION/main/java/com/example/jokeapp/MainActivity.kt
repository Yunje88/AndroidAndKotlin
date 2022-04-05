package com.example.jokeapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btn_submit: Button
    private lateinit var tv_main: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_main = findViewById(R.id.tv_main)
        btn_submit = findViewById(R.id.button)

        btn_submit.setOnClickListener {
            setRetrofit()
        }
    }

    private fun setRetrofit(){

        // start retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // instantiate service
        val service = retrofit.create(JokeService::class.java)
        // put value into the service instance
        val call: Call<JokeData> =service.ApiService()
        call.enqueue(object: Callback<JokeData> {
            override fun onResponse(
                call: Call<JokeData>,
                response: Response<JokeData>
            ) {
                tv_main.text = response.body()?.joke.toString()
                Log.d(TAG,"${response.body()?.joke}")
            }

            override fun onFailure(call: Call<JokeData>, t: Throwable) {
                Log.e(TAG, "FAIL")

            }
        })

    }
}