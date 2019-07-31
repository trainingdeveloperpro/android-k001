package com.trainingdeveloperpro.androidk001.lesson3.nguyenquockhanh

import android.util.Log
import com.trainingdeveloperpro.androidk001.lesson3.nguyenquockhanh.BuildConfig

class DebugLog {
    companion object{
        fun logD(message : String){
            if(BuildConfig.DEBUG) Log.d("Tag", message)
        }
        fun logD(tag : String, message: String){
            if(BuildConfig.DEBUG) Log.d(tag, message)
        }
    }
}