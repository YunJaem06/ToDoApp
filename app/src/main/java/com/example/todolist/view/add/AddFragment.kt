package com.example.todolist.view.add

import android.text.TextUtils
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.data.database.ToDoDatabase
import com.example.todolist.data.model.Priority
import com.example.todolist.data.model.ToDoData
import com.example.todolist.data.repository.ToDoRepository
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.viewmodel.SharedViewModel
import com.example.todolist.viewmodel.SharedViewModelFactory
import com.example.todolist.viewmodel.ToDoViewModel
import com.example.todolist.viewmodel.ToDoViewModelFactory

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {

    private val aSharedViewModel : SharedViewModel by viewModels {
        SharedViewModelFactory(requireContext().applicationContext)
    }
    private lateinit var aToDoViewModel : ToDoViewModel
    override fun init() {

        val dao = ToDoDatabase.getInstance(requireActivity().applicationContext).toDoDao
        val repository = ToDoRepository(dao)
        val factory = ToDoViewModelFactory(repository)

        aToDoViewModel = ViewModelProvider(requireActivity(), factory)[ToDoViewModel::class.java]


        // 뒤로 돌아가기
        binding.ivAddBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // 저장 툴바
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

        binding.snAddRank.onItemSelectedListener = aSharedViewModel.listener

    }
    private fun insertData(){
        binding.apply {
            val aTitle = edtAddName.text.toString()
            val aPriority = snAddRank.selectedItem.toString()
            val aContent = edtAddContent.text.toString()

            val checkData = aSharedViewModel.emptyData(aTitle, aContent)

            if (checkData){
                val newData = ToDoData(
                    0,
                    aTitle,
                    aSharedViewModel.checkPriority(aPriority),
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

}