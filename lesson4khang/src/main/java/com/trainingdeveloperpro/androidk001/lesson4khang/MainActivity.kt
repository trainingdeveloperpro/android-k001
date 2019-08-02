package com.trainingdeveloperpro.androidk001.lesson4khang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "LoginActivity"
private const val CREATE_ACCOUNT_REQUEST = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v(TAG, "onCreate() called")

        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.v(TAG, "onRestoreInstanceState() called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(TAG, "onSaveInstanceState() called")

    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy() called")
    }

    fun login(view: View) {
        val builder: AlertDialog.Builder = this.let {
            AlertDialog.Builder(it)
        }

        builder.setMessage("Email: ${etUser.text}\n Password: ${etPassword.text}")
            ?.setTitle("Logging in...")
        builder.create()?.show()
    }

    fun createAccount(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivityForResult(intent, CREATE_ACCOUNT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CREATE_ACCOUNT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                etUser.setText(data?.getStringExtra(EXTRA_USER_EMAIL).toString())
                etPassword.setText(data?.getStringExtra(EXTRA_USER_PASSWORD).toString())
            }
        }
    }
}
