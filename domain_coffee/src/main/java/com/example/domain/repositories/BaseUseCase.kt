package com.example.domain.repositories

import com.example.utils.Utils.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<in Params, out Type> where Type : Any? {

    abstract suspend fun run(params: Params):Either<Exception, Type>
    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (Type) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val job = scope.async { run(params) }
        scope.launch {
            when (val result = job.await()) {
                is Either.Error -> onFailure(result.exception)
                is Either.Success -> onSuccess(result.data)
            }
        }
    }
}