package com.mg.homeclipboards.domain.data.providers

import com.mg.homeclipboards.domain.model.User

interface LoginUserProvider {
    fun get(): User
}