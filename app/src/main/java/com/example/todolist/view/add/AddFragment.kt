package com.example.todolist.view.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {
    override fun init() {

        binding.ivAddBack.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

    }

}