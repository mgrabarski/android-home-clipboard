package com.mg.homeclipboards.domain.interactor.clipboard

import com.mg.homeclipboards.data.factories.ClipboardFactory
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.types.Name
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.domain.state.UseCaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val ERROR_CLIPBOARD_NAME_IS_EMPTY = "error: clipboard name is empty"

class CreateNewClipboard(
    private val factory: ClipboardFactory
) {

    fun create(name: Name, icon: Icon): Flow<UseCaseResult<Clipboard>> = flow {
        if (name.isNotEmpty()) {
            val clipboard = factory.create(name, icon)

            emit(Success(clipboard))
        } else {
            emit(Failure(ERROR_CLIPBOARD_NAME_IS_EMPTY))
        }
    }
}