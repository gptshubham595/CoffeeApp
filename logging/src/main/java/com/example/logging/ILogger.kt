package com.example.logging

interface ILogger {
    fun d(tag:String, message: String)
    fun v(tag:String, message: String)
    fun w(tag:String, message: String)
    fun e(tag:String, message: String, exception: Exception)
}