package com.example.domain.models.coffees

import com.example.domain.models.IAddOn
import com.example.domain.models.ICoffee

data class MochaCoffee(
    override val name: String = "Mocha",
    override val description: String? = null,
    override val listOfAddOns: List<IAddOn>,
    override val basePrice: Double
) : ICoffee {
    override fun getPrice(): Double {
        return basePrice + listOfAddOns.sumOf { it.price }
    }
}
