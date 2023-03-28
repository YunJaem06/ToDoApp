package com.example.todolist.view.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.model.Priority
import com.example.todolist.data.model.ToDoData
import com.example.todolist.databinding.ItemListBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var dataList = emptyList<ToDoData>()

    inner class ListViewHolder(val binding : ItemListBinding, val context : Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ToDoData){
            binding.itemTvTitle.text = item.title
            binding.itemTvContent.text = item.description

            when(item.priority) {
                Priority.HIGH -> binding.itemCvPriority.setCardBackgroundColor(ContextCompat.getColor(context, R.color.red))
                Priority.MEDIUM -> binding.itemCvPriority.setCardBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
                Priority.LOW -> binding.itemCvPriority.setCardBackgroundColor(ContextCompat.getColor(context, R.color.green))

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newDataList: List<ToDoData>) {
        val diffResult = DiffUtil.calculateDiff(
            ToDoDataDiffCallback(dataList, newDataList)
        )
        dataList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }

    private class ToDoDataDiffCallback(private val oldList: List<ToDoData>, private val newList: List<ToDoData>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}