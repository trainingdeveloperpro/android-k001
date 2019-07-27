package com.trainingdeveloperpro.androidk001.lesson3khang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

private const val TAG = "RegisterActivity"

const val EXTRA_USER_EMAIL = "com.example.lesson03.EMAIL"
const val EXTRA_USER_PASSWORD = "com.example.lesson03.PASSWORD"
const val STATE_EMAIL = "email"
const val STATE_PASSWORD = "password"

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.hide()

        if (savedInstanceState != null) {
            Log.v(TAG, "Loading saved Instance state")


            et_user.setText(savedInstanceState.getString(STATE_EMAIL, ""))
            Log.d(TAG, STATE_EMAIL + savedInstanceState.getString(STATE_EMAIL, ""))

            et_password.setText(savedInstanceState.getString(STATE_PASSWORD, ""))
            Log.d(TAG, STATE_PASSWORD + savedInstanceState.getString(STATE_PASSWORD, ""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(TAG, "onSaveInstanceState() called")

        outState.putString(STATE_EMAIL, et_user.text.toString())
        outState.putString(STATE_PASSWORD, et_password.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy() called")
    }

    fun register(view: View) {
        val data: Intent = Intent()
        data.putExtra(EXTRA_USER_EMAIL, et_user.text.toString())
        data.putExtra(EXTRA_USER_PASSWORD, et_password.text.toString())

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}