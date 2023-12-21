package com.example.domain.usecases

import com.example.domain.models.ICoffee
import com.example.domain.repositories.BaseUseCase
import com.example.domain.repositories.ICoffeeRepository
import com.example.utils.Utils.Either
import kotlinx.coroutines.flow.Flow

class UpdateCoffeeUseCase(private val coffeeRepository: ICoffeeRepository) :
    BaseUseCase<ICoffee, Flow<ICoffee>>() {
    override suspend fun run(params: ICoffee): Either<Exception, Flow<ICoffee>> {
        return coffeeRepository.updateCoffee(params)
    }
}