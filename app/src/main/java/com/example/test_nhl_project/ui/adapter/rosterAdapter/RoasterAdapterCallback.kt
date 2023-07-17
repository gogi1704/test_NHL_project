package com.example.test_nhl_project.ui.adapter.rosterAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel

class RoasterAdapterCallback : DiffUtil.ItemCallback<RosterModel>() {
    override fun areItemsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
        return oldItem == newItem
    }
}