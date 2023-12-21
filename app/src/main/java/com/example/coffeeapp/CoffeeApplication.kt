package com.example.coffeeapp

import android.app.Application
import com.example.logging.Logger

class CoffeeApplication: Application() {
    private val logger = Logger()
    private val TAG = CoffeeApplication::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        logger.d(TAG, "onCreate")
    }
}