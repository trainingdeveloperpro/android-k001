package com.trainingdeveloperpro.androidk001.lesson3.nguyenquockhanh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat

class signUp : AppCompatActivity() {
val TAG : String = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }
        Log.v(TAG, "App created")
    }
    override fun onStart() {
        super.onStart()
        Log.v(TAG, "App starting")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "App resuming")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "App paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "App restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "App stopping")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "App destroyed")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

}
