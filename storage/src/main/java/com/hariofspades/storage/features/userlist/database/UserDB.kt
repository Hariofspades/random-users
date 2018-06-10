package com.hariofspades.storage.features.userlist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.storage.features.userlist.dao.UserDao

@Database(
        entities = [(ResultsItemEntity::class)],
        version = 1,
        exportSchema = false
)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDao

}