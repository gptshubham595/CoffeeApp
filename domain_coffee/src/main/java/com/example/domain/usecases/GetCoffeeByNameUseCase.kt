package com.example.domain.usecases

import com.example.domain.models.ICoffee
import com.example.domain.repositories.BaseUseCase
import com.example.domain.repositories.ICoffeeRepository
import com.example.utils.Utils.Either
import kotlinx.coroutines.flow.Flow

class GetCoffeeByNameUseCase(private val coffeeRepository: ICoffeeRepository) :
    BaseUseCase<String, Flow<List<ICoffee>>>() {
    override suspend fun run(params: String): Either<Exception, Flow<List<ICoffee>>> {
        return coffeeRepository.getCoffeeByName(params)
    }
}