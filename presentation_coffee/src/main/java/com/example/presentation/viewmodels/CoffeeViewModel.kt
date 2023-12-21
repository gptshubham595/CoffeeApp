package com.example.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ICoffee
import com.example.domain.usecases.AddCoffeeUseCase
import com.example.domain.usecases.GetCoffeeByNameUseCase
import com.example.domain.usecases.GetListOfCoffeeUseCase
import com.example.domain.usecases.RemoveCoffeeUseCase
import com.example.domain.usecases.UpdateCoffeeUseCase
import com.example.logging.Logger
import kotlinx.coroutines.launch

class CoffeeViewModel(
    private val addCoffeeUseCase: AddCoffeeUseCase,
    private val getCoffeeByNameUseCase: GetCoffeeByNameUseCase,
    private val updateCoffeeUseCase: UpdateCoffeeUseCase,
    private val removeCoffeeUseCase: RemoveCoffeeUseCase,
    private val getCoffeeListUseCase: GetListOfCoffeeUseCase,
    private val logger: Logger
) : ViewModel() {

    private val _coffeeList = MutableLiveData<List<ICoffee>>()
    val coffeeList: LiveData<List<ICoffee>> = _coffeeList

    private val _coffeeRemoved = MutableLiveData<ICoffee>()
    val coffeeRemoved: LiveData<ICoffee> = _coffeeRemoved

    private val _coffeeAdded = MutableLiveData<ICoffee>()
    val coffeeAdded: LiveData<ICoffee> = _coffeeAdded

    private val _coffeeUpdated = MutableLiveData<ICoffee>()
    val coffeeUpdated: LiveData<ICoffee> = _coffeeUpdated

    private val _coffeeByName = MutableLiveData<List<ICoffee>>()
    val coffeeByName: LiveData<List<ICoffee>> = _coffeeByName

    private val TAG = CoffeeViewModel::class.java.simpleName
    fun getListOfCoffees() {
        getCoffeeListUseCase(
            scope = viewModelScope,
            params = Unit,
            onSuccess = {
                viewModelScope.launch {
                    it.collect {
                        _coffeeList.postValue(it)
                    }
                }
            },
            onFailure = {
                logger.e(TAG, it.message.toString(), it)
            }
        )
    }

    fun removeACoffee(coffee: ICoffee) {
        removeCoffeeUseCase(
            scope = viewModelScope,
            params = coffee,
            onSuccess = {
                viewModelScope.launch {
                    it.collect {
                        _coffeeRemoved.postValue(it)
                    }
                }
            },
            onFailure = {
                logger.e(TAG, it.message.toString(), it)
            }
        )
    }

    fun addACoffee(coffee: ICoffee) {
        addCoffeeUseCase(
            scope = viewModelScope,
            params = coffee,
            onSuccess = {
                viewModelScope.launch {
                    it.collect {
                        _coffeeAdded.postValue(it)
                    }
                }
            },
            onFailure = {
                logger.e(TAG, it.message.toString(), it)
            }
        )
    }

    fun updateACoffee(coffee: ICoffee) {
        updateCoffeeUseCase(
            scope = viewModelScope,
            params = coffee,
            onSuccess = {
                viewModelScope.launch {
                    it.collect {
                        _coffeeUpdated.postValue(it)
                    }
                }
            },
            onFailure = {
                logger.e(TAG, it.message.toString(), it)
            }
        )
    }

    fun getCoffeeByName(coffeeSubstring: String) {
        getCoffeeByNameUseCase(
            scope = viewModelScope,
            params = coffeeSubstring,
            onSuccess = {
                viewModelScope.launch {
                    it.collect {
                        _coffeeList.postValue(it)
                    }
                }
            },
            onFailure = {
                logger.e(TAG, it.message.toString(), it)
            }
        )
    }
}