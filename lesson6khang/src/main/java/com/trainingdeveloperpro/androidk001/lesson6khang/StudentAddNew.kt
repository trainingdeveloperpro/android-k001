package com.trainingdeveloperpro.androidk001.lesson6khang

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_student_add.*

class StudentAddNew : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_add)

        val button = btn_add as Button
        button.setOnClickListener {
            val newName = findViewById<EditText>(R.id.et_name).text.toString()
            val newAge = findViewById<EditText>(R.id.et_age).text.toString()
            val newPhonenumber = findViewById<EditText>(R.id.et_phoneNumber).text.toString()

            val resultIntent = Intent().apply {
                putExtra(NAME, newName)
                putExtra(AGE, newAge)
                putExtra(PHONENUMBER, newPhonenumber)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

    }
}