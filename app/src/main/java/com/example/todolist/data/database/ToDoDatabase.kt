package com.example.todolist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todolist.data.model.ToDoData

@Database(entities = [ToDoData::class], version = 1)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

//    abstract fun toDoDao() : ToDoDao
    abstract val toDoDao : ToDoDao

    companion object {

        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getInstance(context: Context) : ToDoDatabase {

            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "todo_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
