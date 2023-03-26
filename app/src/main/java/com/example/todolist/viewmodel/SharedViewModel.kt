package com.example.todolist.viewmodel

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import com.example.todolist.data.model.Priority

class SharedViewModel : ViewModel() {


    fun emptyData(title: String, content: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            false
        } else !(title.isEmpty() || content.isEmpty())
    }

    fun checkPriority(priority: String): Priority {
        return when (priority) {
            "높음" -> {
                Priority.HIGH
            }
            "중간" -> {
                Priority.MEDIUM
            }
            "낮음" -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }

}