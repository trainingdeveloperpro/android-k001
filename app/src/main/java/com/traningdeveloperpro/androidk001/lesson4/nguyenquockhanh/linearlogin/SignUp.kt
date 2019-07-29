package com.traningdeveloperpro.androidk001.lesson4.nguyenquockhanh.linearlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_sign_up.view.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
//        supportActionBar?.hide()
        val mail = intent.getStringExtra(Mail)
        val pass = intent.getStringExtra(Pass)

        val register_mail = findViewById<EditText>(R.id.edit_text_register_mail)
            register_mail.setText(mail)

        val register_pass = findViewById<EditText>(R.id.edit_text_register_pass)
            register_pass.setText(pass)
    }
}
