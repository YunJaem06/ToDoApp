package com.example.todolist.view.update

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(R.layout.fragment_update) {
    override fun init() {

        binding.ivUpdateBack.setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
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