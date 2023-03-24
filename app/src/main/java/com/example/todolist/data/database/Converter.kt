package com.example.todolist.data.database

import androidx.room.TypeConverter
import com.example.todolist.data.model.Priority

class Converter {

    // TypeConverter를 사용하여 데이터베이스에서 자동으로 그 자료형에 맞는 메소드를 호출하게 만듬
    @TypeConverter
    fun fromPriority(priority: Priority) : String {

        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String) : Priority{
        return Priority.valueOf(priority)
    }
}