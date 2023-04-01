package com.example.todolist.view.update

import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.data.database.ToDoDatabase
import com.example.todolist.data.model.Priority
import com.example.todolist.data.model.ToDoData
import com.example.todolist.data.repository.ToDoRepository
import com.example.todolist.databinding.FragmentUpdateBinding
import com.example.todolist.viewmodel.SharedViewModel
import com.example.todolist.viewmodel.SharedViewModelFactory
import com.example.todolist.viewmodel.ToDoViewModel
import com.example.todolist.viewmodel.ToDoViewModelFactory

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(R.layout.fragment_update) {

    private val args by navArgs<UpdateFragmentArgs>()

    private val uSharedViewModel : SharedViewModel by viewModels {
        SharedViewModelFactory(requireContext().applicationContext)
    }
    private lateinit var uToDoViewModel : ToDoViewModel

    override fun init() {

        val dao = ToDoDatabase.getInstance(requireActivity().applicationContext).toDoDao
        val repository = ToDoRepository(dao)
        val factory = ToDoViewModelFactory(repository)

        uToDoViewModel = ViewModelProvider(requireActivity(), factory)[ToDoViewModel::class.java]

        // 뒤로 돌아가기
        binding.ivUpdateBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.toolbarUpdate.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.menu_update){
                    updateItem()
                }
                return true
            }

        })

        binding.edtUpdateName.setText(args.currentItem.title)
        binding.edtUpdateContent.setText(args.currentItem.description)
        binding.snUpdateRank.setSelection(uSharedViewModel.parsePriority(args.currentItem.priority))
        binding.snUpdateRank.onItemSelectedListener = uSharedViewModel.listener
    }

    private fun updateItem(){
        val title = binding.edtUpdateName.text.toString()
        val content = binding.edtUpdateContent.text.toString()
        val priority = binding.snUpdateRank.selectedItem.toString()

        val validation = uSharedViewModel.emptyData(title, content)
        if (validation){
            val updateItem = ToDoData(
                args.currentItem.id,
                title,
                uSharedViewModel.checkPriority(priority),
                content
            )
            uToDoViewModel.updateData(updateItem)
            showCustomToast("수정하였습니다")
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            showCustomToast("다시 수정해주세요")
        }
    }
}