package com.trainingdeveloperpro.androidk001.lesson6linh


import android.util.Log

class LogTool {
    companion object {
        fun logD(tag: String, message: String) {
            if (BuildConfig.DEBUG)
                Log.d(tag, message)
        }
    }
}