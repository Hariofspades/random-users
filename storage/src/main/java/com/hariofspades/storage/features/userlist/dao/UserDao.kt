package com.hariofspades.storage.features.userlist.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hariofspades.domain.features.userlist.model.ResultsItem

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts : List<ResultsItem>)

    @Query("SELECT * FROM users")
    fun getUserList(): List<ResultsItem>
}