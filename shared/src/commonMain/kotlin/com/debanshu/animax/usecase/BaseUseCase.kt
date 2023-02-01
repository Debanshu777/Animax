package com.debanshu.animax.usecase

abstract class BaseUseCase<REQUEST,RESPONSE> {
    @Throws(Exception::class)
    abstract suspend fun execute(request: REQUEST):RESPONSE
}