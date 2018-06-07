package com.hariofspades.data.features.userlist.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hariofspades.domain.features.userlist.model.ResultsItem

@Database(
        entities = [(ResultsItem::class)],
        version = 1,
        exportSchema = false
)
abstract class UserDB : RoomDatabase() {

    abstract fun users(): UserDao

    companion object {

        fun create(context: Context, useInMemory : Boolean): UserDB {

            val databaseBuilder = Room.databaseBuilder(context, UserDB::class.java, "user.db")

            return databaseBuilder
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}