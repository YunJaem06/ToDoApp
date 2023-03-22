package com.example.todolist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoData(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    var id: Int,

    @ColumnInfo(name = "todo_title")
    var title: String,

    @ColumnInfo(name = "todo_priority")
    var priority: Priority,

    @ColumnInfo(name = "todo_description")
    var description: String
)