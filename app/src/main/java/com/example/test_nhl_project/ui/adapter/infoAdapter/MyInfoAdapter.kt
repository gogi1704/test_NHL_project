package com.example.test_nhl_project.ui.adapter.infoAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_nhl_project.data.models.myModels.MyInfoModel
import com.example.test_nhl_project.databinding.InfoItemLayoutBinding

class MyInfoAdapter :
    ListAdapter<MyInfoModel, MyInfoAdapter.MyInfoViewHolder>(InfoAdapterCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyInfoViewHolder {
        val binding =
            InfoItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyInfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class MyInfoViewHolder(val binding: InfoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyInfoModel) {
            with(binding) {
                textTitle.text = item.title
                textContent.text = item.content
            }
        }
    }
}