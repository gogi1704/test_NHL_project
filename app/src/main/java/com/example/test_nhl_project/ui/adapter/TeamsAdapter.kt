package com.example.test_nhl_project.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_nhl_project.data.models.myModels.MyTeamModel
import com.example.test_nhl_project.databinding.TeamItemLayoutBinding

class TeamsAdapter() : ListAdapter<MyTeamModel, TeamsAdapter.TeamsViewHolder>(MyAdapterCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val binding =
            TeamItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TeamsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TeamsViewHolder(private val binding: TeamItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyTeamModel) {
            binding.TeamName.text = item.name
            binding.imageLock.visibility = if (item.isOpen) View.GONE else View.VISIBLE
        }

    }
}