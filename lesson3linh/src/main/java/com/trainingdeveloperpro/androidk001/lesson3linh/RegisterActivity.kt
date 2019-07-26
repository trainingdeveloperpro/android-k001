package com.trainingdeveloperpro.androidk001.lesson3linh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

private val TAG = RegisterActivity::class.java.simpleName

const val EXTRA_USER_EMAIL = "com.trainingdeveloperpro.androidk001.lesson3linh.USER_EMAIL"
const val EXTRA_USER_PASSWORD = "com.trainingdeveloperpro.androidk001.lesson3linh.USER_PASSWORD"

const val BUNDLE_STATE_FIRST_NAME = "FIRST_NAME"
const val BUNDLE_STATE_LAST_NAME = "LAST_NAME"
const val BUNDLE_STATE_EMAIL = "EMAIL"
const val BUNDLE_STATE_PASSWORD = "PASSWORD"

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DebugLog.logV(TAG, "onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        if (savedInstanceState != null) {
            DebugLog.logV(TAG, "Loading saved Instance state")

            edittext_register_first_name.setText(savedInstanceState.getString(BUNDLE_STATE_FIRST_NAME, ""))
            Log.d(TAG, BUNDLE_STATE_FIRST_NAME + savedInstanceState.getString(BUNDLE_STATE_FIRST_NAME, ""))

            edittext_register_last_name.setText(savedInstanceState.getString(BUNDLE_STATE_LAST_NAME, ""))
            Log.d(TAG, BUNDLE_STATE_LAST_NAME + savedInstanceState.getString(BUNDLE_STATE_LAST_NAME, ""))

            edittext_register_email.setText(savedInstanceState.getString(BUNDLE_STATE_EMAIL, ""))
            Log.d(TAG, BUNDLE_STATE_EMAIL + savedInstanceState.getString(BUNDLE_STATE_EMAIL, ""))

            edittext_register_password.setText(savedInstanceState.getString(BUNDLE_STATE_PASSWORD, ""))
            Log.d(TAG, BUNDLE_STATE_PASSWORD + savedInstanceState.getString(BUNDLE_STATE_PASSWORD, ""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        DebugLog.logV(TAG, "onSaveInstanceState() called")

        outState.putString(BUNDLE_STATE_FIRST_NAME, edittext_register_first_name.text.toString())
        outState.putString(BUNDLE_STATE_LAST_NAME, edittext_register_last_name.text.toString())
        outState.putString(BUNDLE_STATE_EMAIL, edittext_register_email.text.toString())
        outState.putString(BUNDLE_STATE_PASSWORD, edittext_register_password.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        DebugLog.logV(TAG, "onDestroy() called")
    }

    fun register(view: View) {
        val data = Intent()
        data.putExtra(EXTRA_USER_EMAIL, edittext_register_email.text.toString())
        data.putExtra(EXTRA_USER_PASSWORD, edittext_register_password.text.toString())

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
