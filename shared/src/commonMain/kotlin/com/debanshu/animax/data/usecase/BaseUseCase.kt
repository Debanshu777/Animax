package com.debanshu.animax.data.usecase

abstract class BaseUseCase<REQUEST,RESPONSE> {
    @Throws(Exception::class)
    abstract suspend fun execute(request: REQUEST):RESPONSE
}