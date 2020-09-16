package com.project.androidroom

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BookDao {

    @Insert
    fun insert(book: Book)
}