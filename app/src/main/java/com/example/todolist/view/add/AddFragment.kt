package com.example.todolist.view.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {
    override fun init() {

        binding.ivAddBack.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        binding.toolbarAdd.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        })

    }

}