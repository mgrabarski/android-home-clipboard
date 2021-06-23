package com.mg.homeclipboards.repository.domainimpl

import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboards.domain.data.providers.LoginUserProvider
import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.types.NumberOfInserts
import com.mg.homeclipboards.domain.repository.ClipboardRepository
import com.mg.homeclipboards.repository.local.ClipboardLocalStorage
import com.mg.homeclipboards.repository.remote.ClipboardRemoteStorage

class HomeClipboardRepository(
    private val clipboardLocalStorage: ClipboardLocalStorage,
    private val clipboardRemoteStorage: ClipboardRemoteStorage,
    private val loginUserProvider: LoginUserProvider
) : ClipboardRepository {

    override suspend fun insertClipboard(clipboard: Clipboard): NumberOfInserts {
        val rowId = clipboardLocalStorage.insert(clipboardEntity = toEntity(clipboard))

        return if (rowId > 0) {
            clipboardRemoteStorage.insert(clipboard)
            1
        } else {
            0
        }
    }

    private fun toEntity(clipboard: Clipboard) = ClipboardEntity(
        id = clipboard.id.toString(),
        name = clipboard.displayName,
        icon = clipboard.icon.name,
        createDate = clipboard.createDate.date,
        userId = loginUserProvider.get().id.toString()
    )
}