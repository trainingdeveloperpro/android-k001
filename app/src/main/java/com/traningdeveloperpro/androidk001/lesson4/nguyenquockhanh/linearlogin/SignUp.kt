package com.traningdeveloperpro.androidk001.lesson4.nguyenquockhanh.linearlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
//        supportActionBar?.hide()
        val mail = intent.getStringExtra(Mail)
        val pass = intent.getStringExtra(Pass)

        val registerMail = findViewById<EditText>(R.id.edit_text_register_mail)
            registerMail.setText(mail)

        val registerPassword = findViewById<EditText>(R.id.edit_text_register_password)
            registerPassword.setText(pass)
    }
}
