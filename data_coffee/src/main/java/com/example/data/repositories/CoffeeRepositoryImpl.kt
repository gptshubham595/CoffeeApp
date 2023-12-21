package com.example.data.repositories

import com.example.domain.models.ICoffee
import com.example.domain.repositories.ICoffeeRepository
import com.example.utils.Utils
import kotlinx.coroutines.flow.Flow

class CoffeeRepositoryImpl: ICoffeeRepository {
    override suspend fun getListOfAllCoffee(): Utils.Either<Exception, Flow<List<ICoffee>>> {
        TODO("Not yet implemented")
    }

    override suspend fun addCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>> {
        TODO("Not yet implemented")
    }

    override suspend fun removeCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCoffee(coffee: ICoffee): Utils.Either<Exception, Flow<ICoffee>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoffeeByName(coffeeSubstring: String): Utils.Either<Exception, Flow<List<ICoffee>>> {
        TODO("Not yet implemented")
    }
}