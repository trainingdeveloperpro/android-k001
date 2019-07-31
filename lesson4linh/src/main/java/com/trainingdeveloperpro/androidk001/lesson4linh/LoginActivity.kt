package com.trainingdeveloperpro.androidk001.lesson4linh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_log_in.*

private val TAG = LoginActivity::class.java.simpleName

private const val CREATE_ACCOUNT_REQUEST = 1

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        LogTool.logV(TAG, "onCreate() called!")
    }

    override fun onResume() {
        super.onResume()
        LogTool.logV(TAG, "onResume() called!")
    }

    override fun onStart() {
        super.onStart()
        LogTool.logV(TAG, "onStart() called!")
    }

    override fun onRestart() {
        super.onRestart()
        LogTool.logV(TAG, "onRestart() called!")
    }

    override fun onPause() {
        super.onPause()
        LogTool.logV(TAG, "onPause() called!")
    }

    override fun onStop() {
        super.onStop()
        LogTool.logV(TAG, "onStop() called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogTool.logV(TAG, "onDestroy() called!")
    }

    fun login(view: View) {
        val builder: AlertDialog.Builder = this.let {
            AlertDialog.Builder(it)
        }

        builder.setMessage(
            getString(
                R.string.login_dialog_message,
                edittext_register_email.text,
                edittext_register_password.text
            )
        )
            ?.setTitle(getString(R.string.login_dialog_title))
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
