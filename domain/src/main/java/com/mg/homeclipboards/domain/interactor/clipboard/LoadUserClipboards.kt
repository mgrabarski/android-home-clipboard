package com.mg.homeclipboards.domain.interactor.clipboard

import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.repository.ClipboardRepository
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.domain.state.UseCaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoadUserClipboards(
    private val clipboardRepository: ClipboardRepository
) {

    fun load(): Flow<UseCaseResult<List<Clipboard>>> = flow {
        val loginUserId = LoginUserHolder.loginUser.id
        val result = clipboardRepository.loadUserClipboards(loginUserId)
        emit(Success(result = result))
    }
}