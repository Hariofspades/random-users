package com.hariofspades.storage.features.userlist.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts : List<ResultsItemEntity>)

    @Query("SELECT * FROM users")
    fun getUserList(): List<ResultsItemEntity>

    @Query("SELECT * FROM users WHERE firstName = :firstName")
    fun getOneUser(firstName: String): ResultsItemEntity

    @Query("DELETE from users")
    fun clearRows()
}