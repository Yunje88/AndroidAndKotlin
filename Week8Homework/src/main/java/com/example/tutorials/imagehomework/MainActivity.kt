package com.example.tutorials.imagehomework

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.example.tutorials.imagehomework.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

private lateinit var binding : ActivityMainBinding

var index = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        view.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View, m: MotionEvent): Boolean {
                handleTouch(m)
                return true
            }

        })

    }

    private fun handleTouch(m:MotionEvent) {

        val pointerCount = m.pointerCount
        for (i in 0 until pointerCount) {
            val action = m.actionMasked

            when (action) {
                MotionEvent.ACTION_MOVE -> {
                    if (index >= 9) {
                        index = 0
                    } else {
                        index++
                    }
                }
            }

            binding.textStatus.text = commonData.getImageDescriptionAtIndex(index)

            GlobalScope.launch(Dispatchers.IO) {

                val imageUrl = URL(commonData.getImageUrlAtIndex(index))
                val httpConnection: HttpURLConnection =
                    imageUrl.openConnection() as HttpURLConnection
                httpConnection.doInput = true
                httpConnection.connect()

                val inputStream = httpConnection.inputStream
                val bitmapImage = BitmapFactory.decodeStream(inputStream)
                launch(Dispatchers.Main) {
                    binding.imageView.setImageBitmap(bitmapImage)
                }

            }

        }
    }


}