package com.trainingdeveloperpro.androidk001.lesson4dat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar!!.hide()
        Log.i(tag, "on create!")
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "on Start!")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "on Resume!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "on Pause!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "on Stop!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "on Restart!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "on Destroy!")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        val tag = "Register"
    }
}
