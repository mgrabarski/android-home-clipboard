package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.model.User

object LoginUserHolder {

    var loginUser: User? = null
        internal set
}