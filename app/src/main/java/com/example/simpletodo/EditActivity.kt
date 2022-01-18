package com.example.simpletodo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val text = getIntent().getStringExtra("thisText")
        val pos = getIntent().getIntExtra("position", -1)

        //set text field
        val editTextField = findViewById<TextView>(R.id.editTextView)
        editTextField.setText(text)
        val inputTextField = findViewById<EditText>(R.id.editTaskField)
        inputTextField.setText(text)
        val data = Intent()

        findViewById<Button>(R.id.btnEdit).setOnClickListener{
            val userInputtedTask = inputTextField.text.toString()
            data.putExtra("userInput", userInputtedTask)
            data.putExtra("position", pos)

            setResult(RESULT_OK, data)
            finish()
        }


        btnBack.setOnClickListener{
            finish()
        }
    }

}