package com.example.todolist.viewmodel

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.todolist.R
import com.example.todolist.data.model.Priority

class SharedViewModel(val context : Context) : ViewModel() {

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

    val listener : AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(position){
                0 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.red))}
                1 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.yellow))}
                2 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.green))}
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }

    }

    fun parsePriority(priority: Priority) : Int {
        return when(priority){
            Priority.HIGH -> 0
            Priority.MEDIUM -> 1
            Priority.LOW -> 2
        }
    }

}