package com.example.todolist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoData(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var title: String,

    var priority: Priority,

    var description: String
)