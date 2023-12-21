package com.example.data.models


data class Coffee(
    val name: String,
    val description: String,
    val basePrice: Double
)

data class AddOn(
    val name: String,
    val price: Double
)

