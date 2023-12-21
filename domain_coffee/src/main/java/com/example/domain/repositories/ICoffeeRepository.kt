package com.example.domain.repositories

import com.example.domain.models.ICoffee
import com.example.utils.Utils
import kotlinx.coroutines.flow.Flow

interface ICoffeeRepository {

    suspend fun getListOfAllCoffee(): Utils.Either<Exception, Flow<List<ICoffee>>>

    suspend fun addCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>>

    suspend fun removeCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>>
    suspend fun updateCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>>

    suspend fun getCoffeeByName(coffeeSubstring: String): Utils.Either<Exception, Flow<List<ICoffee>>>

}