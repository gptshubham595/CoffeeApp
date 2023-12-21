package com.example.domain.models.addOns

import com.example.domain.models.IAddOn

data class MilkAddOn(
    override val name: String = "Foam",
    override val price: Double = 12.0
) : IAddOn