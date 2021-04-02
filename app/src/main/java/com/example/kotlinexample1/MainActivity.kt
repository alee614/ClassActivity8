package com.example.kotlinexample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // private
    // var -> change the value later
    // val -> constant

    // promises that you will initialize later
    private lateinit var buttonGo : Button // want a variable called buttonGo that's Button type that will be initalized later
    private lateinit var editTextName : EditText
    private lateinit var binding : ActivityMainBinding
    private lateinit var buttonVillagers : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContent is the root of the binding
        setContentView(binding.root)
        // binding automatically had reference to all the children
        buttonGo = binding.buttonGo
        editTextName = binding.editTextName
        buttonVillagers = binding.buttonVillagers

        /**
        setContentView(R.layout.activity_main)

        buttonGo = findViewById(R.id.button_go)
        editTextName = findViewById(R.id.editText_name)
        */


        buttonGo.setOnClickListener{
            toastInput(editTextName.text.toString());
            launchSecondActivity(editTextName.text.toString())
        }
        buttonVillagers.setOnClickListener {
            launchThirdActivity()
        }

    }

    private fun toastInput(text : String){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun launchSecondActivity(message : String){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", message)
        Log.d("message", message)
        startActivity(intent)
    }

    private fun launchThirdActivity(){
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}