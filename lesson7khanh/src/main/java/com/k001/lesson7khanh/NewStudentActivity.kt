package com.k001.lesson7khanh

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val newName = findViewById<EditText>(R.id.edit_text_register_name)
        val newAge = findViewById<EditText>(R.id.edit_text_register_age)
        val newTelephone = findViewById<EditText>(R.id.edit_text_register_telephone)
        val buttonRegister = findViewById<Button>(R.id.add_button)

        buttonRegister.setOnClickListener{
            val replyIntent = Intent()

            if(TextUtils.isEmpty(newName.text) || TextUtils.isEmpty(newAge.text) || TextUtils.isEmpty(newTelephone.text))
                setResult(Activity.RESULT_CANCELED, replyIntent)
            else {
                replyIntent.putExtra(EXTRA_NAME, newName.text.toString())
                replyIntent.putExtra(EXTRA_AGE, newAge.text.toString())
                replyIntent.putExtra(EXTRA_TELEPHONE, newTelephone.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object{
        const val EXTRA_NAME = "name"
        const val EXTRA_AGE = "age"
        const val EXTRA_TELEPHONE = "telephone"
    }
}
