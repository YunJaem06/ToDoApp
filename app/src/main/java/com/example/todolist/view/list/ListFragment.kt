package com.example.todolist.view.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {
    override fun init() {

        binding.floatBtnList.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }
}