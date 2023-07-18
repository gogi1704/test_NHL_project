package com.example.test_nhl_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.databinding.FragmentInfoBinding
import com.example.test_nhl_project.ui.adapter.infoAdapter.MyInfoAdapter
import com.example.test_nhl_project.viewModels.InfoViewModel

class InfoFragment : Fragment() {
    private val viewModel: InfoViewModel by viewModels()
    private lateinit var binding: FragmentInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        val adapter = MyInfoAdapter()
        binding.recycler.adapter = adapter




        viewModel.liveDate.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }



        return binding.root
    }

}