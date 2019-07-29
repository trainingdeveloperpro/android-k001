package com.traningdeveloperpro.androidk001.lesson4.nguyenquockhanh.linearlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText

val Mail : String = "abc"
val Pass : String = "abc"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
    }

    override fun onPause() {
        super.onPause()
        DebugLog.logD("app", "paused")
    }

    fun signUp(view : View){
        val edit_text_email = findViewById<EditText>(R.id.edit_text_email)
        val mail = edit_text_email.text.toString()
        val edit_text_pass = findViewById<EditText>(R.id.edit_text_pass).text
        val pass = edit_text_pass.toString()
        val intent = Intent(this, SignUp::class.java).apply {
            putExtra(Mail, mail)
            putExtra(Pass, pass)
        }
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
