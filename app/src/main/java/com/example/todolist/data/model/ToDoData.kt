package com.example.todolist.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var title: String,

    var priority: Priority,

    var description: String
) : Parcelable