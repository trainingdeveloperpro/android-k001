package com.trainingdeveloperpro.androidk001.lesson3linh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

private const val TAG = "LoginActivity"
private const val CREATE_ACCOUNT_REQUEST = 1

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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

        builder.setMessage("Email: ${edittext_register_email.text}\n Password: ${edittext_register_password.text}")
            ?.setTitle("Logging in...")
        builder.create()?.show()
    }

    fun createAccount(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(intent, CREATE_ACCOUNT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CREATE_ACCOUNT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                edittext_register_email.setText(data?.getStringExtra(EXTRA_USER_EMAIL).toString())
                edittext_register_password.setText(data?.getStringExtra(EXTRA_USER_PASSWORD).toString())
            }
        }
    }
}
