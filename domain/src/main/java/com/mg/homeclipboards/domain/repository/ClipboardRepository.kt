package com.mg.homeclipboards.domain.repository

import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.model.types.NumberOfInserts

interface ClipboardRepository {
    suspend fun insertClipboard(clipboard: Clipboard): NumberOfInserts
    suspend fun loadUserClipboards(loginUserId: Id): List<Clipboard>
}