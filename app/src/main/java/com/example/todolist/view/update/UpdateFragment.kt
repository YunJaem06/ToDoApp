package com.example.todolist.view.update

import android.view.*
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(R.layout.fragment_update) {
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

    }
}