package com.example.todolist.view.list

import android.util.Log
import android.view.*
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {
    override fun init() {

        binding.floatBtnList.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        binding.listLayout.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }

        binding.toolbarList.addMenuProvider(object  : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.menu_delete_all -> {
                        Log.i("myTag", "모두삭제 선택")
                    }
                }
                return true
            }

        })
    }
}