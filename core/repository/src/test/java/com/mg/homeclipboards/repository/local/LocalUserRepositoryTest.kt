package com.mg.homeclipboards.repository.local

import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboard.database.dao.UserDao
import com.mg.homeclipboard.database.entities.UserEntity
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.repository.factories.anyUser
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class LocalUserRepositoryTest {

    private val dao: UserDao = mockk()
    private val sut = LocalUserRepository(dao)

    @Test
    internal fun `Inserts user`() = testBlocking {
        val user = anyUser()
        val entity = UserEntity(user.id.toString())
        coEvery { dao.insert(entity) } returns 1

        val result = sut.insertUser(user)

        result shouldBeGreaterThan 0
        coVerify(exactly = 1) { dao.insert(entity) }
    }

    @Test
    internal fun `Finds user`() = testBlocking {
        val user = anyUser()
        val entity = UserEntity(user.id.toString())
        coEvery { dao.findById(user.id.toString()) } returns entity

        val result = sut.findUserById(user.id)

        result!!.id shouldBe user.id
    }

    @Test
    internal fun `Find user return null when dao not find the user`() = testBlocking {
        coEvery { dao.findById(any()) } returns null

        val result = sut.findUserById(Id.randomUUID())

        result shouldBe null
    }
}