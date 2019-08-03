package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_add.*

class AddNew : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)

        val button = add_button as Button
        button.setOnClickListener {
            val newName = findViewById<EditText>(R.id.edit_text_register_name).text.toString()
            val newAge = findViewById<EditText>(R.id.edit_text_register_age).text.toString()
            val newTelephone = findViewById<EditText>(R.id.edit_text_register_telephone).text.toString()

            val resultIntent = Intent().apply {
                putExtra(NAME, newName)
                putExtra(AGE, newAge)
                putExtra(TELEPHONE, newTelephone)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

    }
}
