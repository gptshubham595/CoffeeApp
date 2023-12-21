package com.example.domain.usecases

import com.example.domain.models.ICoffee
import com.example.domain.repositories.BaseUseCase
import com.example.domain.repositories.ICoffeeRepository
import com.example.utils.Utils.Either
import kotlinx.coroutines.flow.Flow

class GetListOfCoffeeUseCase(private val coffeeRepository: ICoffeeRepository) :
    BaseUseCase<Unit, Flow<List<ICoffee>>>() {
    override suspend fun run(params: Unit): Either<Exception, Flow<List<ICoffee>>> {
        return coffeeRepository.getListOfAllCoffee()
    }
}