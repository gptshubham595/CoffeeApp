package com.example.domain.models

interface ICoffee {
    val name: String
    val description: String?
    val basePrice: Double
    fun getPrice(): Double

    val listOfAddOns: List<IAddOn>
}
