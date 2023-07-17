package com.example.test_nhl_project.ui.adapter.rosterAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.databinding.RosterItemLayoutBinding

class MyRosterAdapter() :
    ListAdapter<RosterModel, MyRosterAdapter.RoasterViewHolder>(RoasterAdapterCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoasterViewHolder {
        val binding =
            RosterItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoasterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoasterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class RoasterViewHolder(private val binding: RosterItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RosterModel) {
            with(binding) {
                textName.text = item.person.fullName
                textPosition.text = item.position.name
                textNumber.text = item.jerseyNumber
            }
        }
    }
}