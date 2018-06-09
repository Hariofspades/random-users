package com.hariofspades.storage

import android.arch.persistence.room.RoomDatabase
import org.junit.runner.RunWith
import android.support.test.runner.AndroidJUnit4
import com.hariofspades.storage.features.userlist.dao.UserDao
import android.arch.persistence.room.Room
import com.hariofspades.storage.features.userlist.database.UserDB
import android.support.test.InstrumentationRegistry
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Completable
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
open class RoomReadWriteTest {

    lateinit var userDao: UserDao
    lateinit var userDB: UserDB

    @Before
    fun createDB() {

        val context = InstrumentationRegistry.getTargetContext()
        userDB = Room.inMemoryDatabaseBuilder(context, UserDB::class.java).build()
        userDao = userDB.userDao()
    }

    @After
    fun closeDB() {
       userDB.close()
    }

    @Test
    fun readWrite() {
        val result = ResultsItem(
                nat = "IND",
                gender = "male",
                phone = "9108278345",
                dob = "1983-07-14 07:29:45",
                firstName = "Hari",
                lastName = "Vignesh",
                title = "Mr",
                registered = "2010-09-24 02:10:42",
                city = "Bengaluru",
                street = "Kalena Agrahara",
                postcode = "560076",
                state = "Karnataka",
                cell = "9108278345",
                email = "hariutd@gmail.com",
                large = "https://randomuser.me/api/portraits/men/83.jpg",
                medium = "https://randomuser.me/api/portraits/med/men/83.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/men/83.jpg"
        )

        Completable.fromAction {userDao.insert(listOf(result))}.subscribe()

        val listUsers = userDao.getUserList()

        assert(listUsers.isNotEmpty())
        assert(listUsers[0].firstName == "Hari")
    }

}