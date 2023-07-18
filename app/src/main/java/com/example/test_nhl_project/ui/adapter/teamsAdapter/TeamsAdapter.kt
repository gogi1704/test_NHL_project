package com.example.test_nhl_project.ui.adapter.teamsAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_nhl_project.data.models.myModels.MyTeamModel
import com.example.test_nhl_project.databinding.TeamItemLayoutBinding

interface AdapterClickListener {
    fun clickMore(id:Int, name:String , location:String , isOpen:Boolean)
}

class TeamsAdapter(private val listener: AdapterClickListener) : ListAdapter<MyTeamModel, TeamsAdapter.TeamsViewHolder>(
    MyTeamsAdapterCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val binding =
            TeamItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TeamsViewHolder(binding , listener)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TeamsViewHolder(private val binding: TeamItemLayoutBinding ,private val  listener: AdapterClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyTeamModel) {
            with(binding) {
                TeamName.text = item.name
                imageLock.visibility = if (item.isOpen) View.GONE else View.VISIBLE
                card.setOnClickListener {
                    listener.clickMore(item.id , item.name , item.location , item.isOpen)
                }
            }


        }

    }
}