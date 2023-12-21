package com.example.domain.models.addOns

import com.example.domain.models.IAddOn

data class CaramelAddOn(
    override val name: String = "Caramel",
    override val price: Double = 5.0
) : IAddOn
