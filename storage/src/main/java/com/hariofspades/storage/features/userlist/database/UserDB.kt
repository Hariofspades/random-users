package com.hariofspades.storage.features.userlist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.storage.features.userlist.dao.UserDao

@Database(
        entities = [(ResultsItem::class)],
        version = 1,
        exportSchema = false
)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        fun create(context: Context): UserDB {

            val databaseBuilder = Room.databaseBuilder(context, UserDB::class.java, USER_DB)

            return databaseBuilder
                    .fallbackToDestructiveMigration()
                    .build()
        }

        private const val USER_DB = "user.db"
    }
}