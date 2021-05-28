package com.mg.homeclipboards.domain.state

sealed class UseCaseResult<out T>

class Success<out T>(val result: T) : UseCaseResult<T>()
class Failure(val message: String) : UseCaseResult<Nothing>()