package com.example.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.domain.models.addOns.CaramelAddOn
import com.example.domain.models.addOns.MilkAddOn
import com.example.domain.models.coffees.EspressoCoffee
import com.example.domain.models.coffees.MochaCoffee
import com.example.logging.Logger
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodels.CoffeeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var coffeeViewModel: CoffeeViewModel
    private val logger: Logger by lazy { Logger() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coffeeViewModel = ViewModelProvider(this)[CoffeeViewModel::class.java]

        initView()
        initObservers()
    }

    private fun initObservers() {
        coffeeViewModel.coffeeList.observe(this) {
            it?.forEach { coffee ->
                logger.d("Coffee", coffee.toString())
            }
        }
        coffeeViewModel.coffeeAdded.observe(this) {
            it?.let { coffee ->
                logger.d("Coffee", coffee.toString())
            }
        }
        coffeeViewModel.coffeeRemoved.observe(this) {
            it?.let { coffee ->
                logger.d("Coffee", coffee.toString())
            }
        }
        coffeeViewModel.coffeeUpdated.observe(this) {
            it?.let { coffee ->
                logger.d("Coffee", coffee.toString())
            }
        }
        coffeeViewModel.coffeeByName.observe(this) {
            it?.forEach { coffee ->
                logger.d("Coffee", coffee.toString())
            }
        }
    }

    private fun initView() {
        coffeeViewModel.addACoffee(
            EspressoCoffee(
                listOfAddOns = listOf(CaramelAddOn(), MilkAddOn()),
                basePrice = 100.0
            )
        )

        coffeeViewModel.addACoffee(
            MochaCoffee(
                listOfAddOns = listOf(CaramelAddOn()),
                basePrice = 120.0
            )
        )

        coffeeViewModel.getListOfCoffees()

        coffeeViewModel.removeACoffee(
            EspressoCoffee(
                listOfAddOns = listOf(CaramelAddOn(), MilkAddOn()),
                basePrice = 100.0
            )
        )

        coffeeViewModel.getCoffeeByName("Mocha")
    }
}