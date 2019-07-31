package com.trainingdeveloperpro.androidk001.lesson4linh

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val TAG = "LoginFragment"

class LoginFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogTool.logV(TAG, "onAttach() called!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogTool.logV(TAG, "onCreate() called!")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogTool.logV(TAG, "onCreateView() called!")
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogTool.logV(TAG, "onActivityCreated() called!")
    }

    override fun onStart() {
        super.onStart()
        LogTool.logV(TAG, "onStart() called!")
    }

    override fun onResume() {
        super.onResume()
        LogTool.logV(TAG, "onResume() called!")
    }

    override fun onPause() {
        super.onPause()
        LogTool.logV(TAG, "onPause() called!")
    }

    override fun onStop() {
        super.onStop()
        LogTool.logV(TAG, "onStop() called!")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogTool.logV(TAG, "onDestroyView() called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogTool.logV(TAG, "onDestroy() called!")
    }

    override fun onDetach() {
        super.onDetach()
        LogTool.logV(TAG, "onDetach() called!")
    }
}
