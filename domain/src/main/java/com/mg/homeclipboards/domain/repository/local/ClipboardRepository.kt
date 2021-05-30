package com.mg.homeclipboards.domain.repository.local

import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.types.NumberOfInserts

interface ClipboardRepository {
    suspend fun insertClipboard(clipboard: Clipboard): NumberOfInserts
}