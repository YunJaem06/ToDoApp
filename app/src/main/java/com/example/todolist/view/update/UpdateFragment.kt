package com.example.todolist.view.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseFragment
import com.example.todolist.R
import com.example.todolist.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(R.layout.fragment_update) {
    override fun init() {

        binding.ivUpdateBack.setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

    }
}