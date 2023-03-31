package com.example.todolist.view.update

import android.view.*
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.data.model.Priority
import com.example.todolist.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(R.layout.fragment_update) {

    private val args by navArgs<UpdateFragmentArgs>()
    override fun init() {

        // 뒤로 돌아가기
        binding.ivUpdateBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.toolbarUpdate.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        })

        binding.edtUpdateName.setText(args.currentItem.title)
        binding.edtUpdateContent.setText(args.currentItem.description)
        binding.snUpdateRank.setSelection(parsePriority(args.currentItem.priority))

    }

    private fun parsePriority(priority: Priority) : Int {
        return when(priority){
            Priority.HIGH -> 0
            Priority.MEDIUM -> 1
            Priority.LOW -> 2
        }
    }
}