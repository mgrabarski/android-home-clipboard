package com.mg.homeclipboard.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mg.homeclipboard.database.DatabaseTestCase
import com.mg.homeclipboard.database.dataset.anyHomeClipboardEntity
import io.kotest.matchers.equality.shouldBeEqualToUsingFields
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ClipboardDaoTest : DatabaseTestCase() {

    private lateinit var dao: ClipboardDao

    @Before
    override fun setUp() {
        super.setUp()
        dao = database.clipboardDao()
    }

    @Test
    fun `Insert and read clipboard`() = runBlocking {
        val clipboard = anyHomeClipboardEntity()
        dao.insert(clipboard)

        val result = dao.findById(clipboard.id)

        result.shouldNotBeNull()
        result.shouldBeEqualToUsingFields(clipboard)
    }
}