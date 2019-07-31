package com.trainingdeveloperpro.androidk001.lesson4linh

import android.util.Log

class LogTool {
    companion object {
        fun logV(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.v(tag, message)
            }
        }

        fun logD(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }
    }
}