package com.trainingdeveloperpro.androidk001.lesson3.nguyenquockhanh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat

class SignUp : AppCompatActivity() {
private const val TAG : String = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }
        DebugLog.logD(TAG, "created")
    }
    override fun onStart() {
        super.onStart()
        DebugLog.logD(TAG, "started")
    }

    override fun onResume() {
        super.onResume()
        DebugLog.logD(TAG, "resumed")
    }

    override fun onPause() {
        super.onPause()
        DebugLog.logD(TAG, "paused")
    }

    override fun onRestart() {
        super.onRestart()
        DebugLog.logD(TAG, "restarted")
    }

    override fun onStop() {
        super.onStop()
        DebugLog.logD(TAG, "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        DebugLog.logD(TAG, "destroyed")
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

}
