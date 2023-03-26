package com.example.todolist.view.add

import android.text.TextUtils
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.data.model.Priority
import com.example.todolist.data.model.ToDoData
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.viewmodel.ToDoViewModel

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {

    private val aToDoViewModel: ToDoViewModel by viewModels()
    override fun init() {

        binding.ivAddBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.toolbarAdd.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.menu_add){
                    insertData()
                }
                return true
            }

        })

    }
    private fun insertData(){
        binding.apply {
            val aTitle = edtAddName.text.toString()
            val aPriority = snAddRank.selectedItem.toString()
            val aContent = edtAddContent.text.toString()

            val checkData = emptyData(aTitle, aContent)

            if (checkData){
                val newData = ToDoData(
                    0,
                    aTitle,
                    checkPriority(aPriority),
                    aContent
                )
                aToDoViewModel.insertData(newData)
                showCustomToast("할일이 추가 되었습니다!")
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            } else {
                showCustomToast("실패")
            }
        }
    }

    // 유효성 검사
    private fun emptyData(title: String, content : String) : Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)){
            false
        } else !(title.isEmpty() || content.isEmpty())
    }

    private fun checkPriority(priority: String) : Priority {
        return when(priority){
            "높음" -> {Priority.HIGH}
            "중간" -> {Priority.MEDIUM}
            "낮음" -> {Priority.LOW}
            else -> Priority.LOW
        }
    }

}