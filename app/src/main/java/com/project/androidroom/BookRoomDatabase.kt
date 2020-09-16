package com.project.androidroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class BookRoomDatabase: RoomDatabase() {

    abstract fun bookDap(): BookDao

    companion object{
        private var bookRoomInstane: BookRoomDatabase? = null
        //synchronized is only make sure single thread running, prevent duplicated add instance
        fun getDatabase(context: Context): BookRoomDatabase? {
            if (bookRoomInstane == null){
                synchronized(BookRoomDatabase::class.java) {
                    if (bookRoomInstane == null){
                        bookRoomInstane = Room.databaseBuilder<BookRoomDatabase>(context.applicationContext,
                            BookRoomDatabase::class.java,"book_database")//name of database
                            .build()
                    }
                }
            }
            return bookRoomInstane
        }
    }
}