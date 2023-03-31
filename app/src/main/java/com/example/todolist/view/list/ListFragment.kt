package com.example.todolist.view.list

import android.util.Log
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.base.BaseFragment
import com.example.todolist.R
import com.example.todolist.data.database.ToDoDatabase
import com.example.todolist.data.repository.ToDoRepository
import com.example.todolist.databinding.FragmentListBinding
import com.example.todolist.viewmodel.ToDoViewModel
import com.example.todolist.viewmodel.ToDoViewModelFactory

class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val adapter : ListAdapter by lazy { ListAdapter() }
    private lateinit var lToDoViewModel : ToDoViewModel
    override fun init() {

        val dao = ToDoDatabase.getInstance(requireActivity().applicationContext).toDoDao
        val repository = ToDoRepository(dao)
        val factory = ToDoViewModelFactory(repository)

        lToDoViewModel = ViewModelProvider(requireActivity(), factory)[ToDoViewModel::class.java]


        binding.floatBtnList.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        binding.toolbarList.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_delete_all -> {
                        Log.i("myTag", "모두삭제 선택")
                    }
                }
                return true
            }

        })

        val recyclerView = binding.rvList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        lToDoViewModel.todo.observe(viewLifecycleOwner, Observer { data->
            adapter.setData(data)
        })
    }
}