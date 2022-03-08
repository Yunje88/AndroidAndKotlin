package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener({sendMessage(it)})

//        button.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(p0: View?){
//                sendMessage(button)
//            }
//        })

//        val button = findViewById<Button>(R.id.button)
//        class MyOnClick : View.OnClickListener {
//            override fun onClick(p0: View?){
//                sendMessage(button)
//            }
//        }
//        button.setOnClickListener(MyOnClick())

    }

    override fun onResume(){
        super.onResume()
        Toast.makeText(this,"OnResume got called!",Toast.LENGTH_SHORT).show()
    }

    override fun onStop(){
        super.onStop()
        Toast.makeText(this,"onPause got called!",Toast.LENGTH_SHORT).show()
    }

    override fun onPause(){
        super.onPause()
        Toast.makeText(this,"onStop got called!",Toast.LENGTH_SHORT).show()
    }
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

}

