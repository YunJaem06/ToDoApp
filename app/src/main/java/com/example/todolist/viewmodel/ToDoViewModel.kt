package com.example.todolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.model.ToDoData
import com.example.todolist.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoViewModel(private val repository: ToDoRepository) : ViewModel() {

    val todo = repository.getAllData

    fun insertData(toDoData: ToDoData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)

        }
    }

}