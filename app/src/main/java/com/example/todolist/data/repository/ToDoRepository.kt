package com.example.todolist.data.repository

import com.example.todolist.data.database.ToDoDao
import com.example.todolist.data.model.ToDoData

class ToDoRepository(private val dao: ToDoDao) {

    val getAllData = dao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        dao.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData){
        dao.updateData(toDoData)
    }

}