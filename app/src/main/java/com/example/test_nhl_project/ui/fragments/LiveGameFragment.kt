package com.example.test_nhl_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test_nhl_project.databinding.FragmentLiveGameBinding


class LiveGameFragment : Fragment() {
    private lateinit var binding: FragmentLiveGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentLiveGameBinding.inflate(layoutInflater , container , false)





        return binding.root
    }


}