package com.hariofspades.data.features.userlist.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hariofspades.domain.features.userlist.model.ResultsItem
import android.arch.paging.DataSource
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts : List<ResultsItem>)

    @Query("SELECT * FROM users")
    fun getUserList(): Flowable<List<ResultsItem>>
}