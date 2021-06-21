package com.mg.homeclipboard.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboard.database.DatabaseTestCase
import com.mg.homeclipboard.database.dataset.anyHomeClipboardEntity
import com.mg.homeclipboard.database.dataset.anyUser
import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboard.database.entities.UserEntity
import io.kotest.matchers.equality.shouldBeEqualToUsingFields
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ClipboardDaoTest : DatabaseTestCase() {

    private lateinit var dao: ClipboardDao
    private lateinit var user: UserEntity

    @Before
    override fun setUp() = testBlocking {
        super.setUp()
        dao = database.clipboardDao()

        user = anyUser()
        database.userDao().insert(user)
    }

    @Test
    fun `Insert and read clipboard`() = testBlocking {
        val clipboard = anyHomeClipboardEntity(userId = user.id)
        dao.insert(clipboard)

        val result = dao.findById(clipboard.id)

        result.shouldNotBeNull()
        result.shouldBeEqualToUsingFields(
            clipboard,
            ClipboardEntity::id,
            ClipboardEntity::userId,
            ClipboardEntity::name
        )
    }

    @Test
    fun `Inserts return row id`() = testBlocking {
        val clipboard = anyHomeClipboardEntity(userId = user.id)

        val rowId = dao.insert(clipboard)

        rowId shouldBeGreaterThan 0
    }
}