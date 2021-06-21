package com.mg.homeclipboard.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboard.database.DatabaseTestCase
import com.mg.homeclipboard.database.dataset.anyUser
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.equality.shouldBeEqualToUsingFields
import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class UserDaoTest : DatabaseTestCase() {

    private lateinit var userDao: UserDao

    @Before
    override fun setUp() {
        super.setUp()
        userDao = database.userDao()
    }

    @Test
    fun `Inserts return row id`() = testBlocking {
        val user = anyUser()

        val rowId = userDao.insert(user)

        rowId shouldBeGreaterThan 0
    }

    @Test
    fun `Inserts and read user`() = testBlocking {
        val user = anyUser()
        userDao.insert(user)

        val result = userDao.findById(user.id)

        result.shouldNotBeNull()
        result.shouldBeEqualToUsingFields(user)
    }
}