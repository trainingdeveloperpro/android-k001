package com.traningdeveloperpro.androidk001.lesson4.nguyenquockhanh.linearlogin

import android.util.Log
import com.traningdeveloperpro.androidk001.lesson4.nguyenquockhanh.linearlogin.BuildConfig

class DebugLog {
    companion object{
        fun logD(message : String){
            if (BuildConfig.DEBUG){
                Log.d("TAG", message)
            }
        }

        fun logD(tag : String, message : String){
            if(BuildConfig.DEBUG) Log.d(tag, message)
        }
    }
}
