package com.hariofspades.data.features.userlist.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import com.hariofspades.domain.features.userlist.model.ResultsItem

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts : List<ResultsItem>)
}