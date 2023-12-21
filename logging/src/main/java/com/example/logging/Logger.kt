package com.example.logging

import android.util.Log

class Logger: ILogger{
    override fun d(tag: String, message: String) {
        if(BuildConfig.DEBUG)
            Log.d(tag, message)
    }

    override fun v(tag: String, message: String) {
        if(BuildConfig.DEBUG)
            Log.d(tag, message)
    }

    override fun w(tag: String, message: String) {
        if(BuildConfig.DEBUG)
            Log.d(tag, message)
    }

    override fun e(tag: String, message: String, exception: Exception) {
        if(BuildConfig.DEBUG)
            Log.d(tag, message)
    }

}