package com.example.clean_architecture_2021.recyclerview.sample

import android.view.View
import android.view.ViewGroup
import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.databinding.FlowerItemBinding
import com.example.clean_architecture_2021.recyclerview.base.BaseAdapter
import com.example.clean_architecture_2021.recyclerview.base.BaseItemCallback
import com.example.clean_architecture_2021.recyclerview.base.BaseViewHolder
import com.example.clean_architecture_2021.recyclerview.sample.data.Flower


/**
 * Created by darkray on 7/15/21 11:23 AM.
 */

class FlowersAdapter : BaseAdapter<Flower>(FlowerDiffCallback) {


    inner class FlowerViewHolder(private val binding: FlowerItemBinding) :
        BaseViewHolder<Flower>(binding) {

        override fun bind(item: Flower) {
            binding.flower = item
            binding.root.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            super.onClick(view)
            mItemClickListener?.onItemClick(view, getItem(layoutPosition))
        }

    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Flower> {
        return FlowerViewHolder(inflate(parent, R.layout.flower_item))
    }
}

object FlowerDiffCallback : BaseItemCallback<Flower>() {

    override fun areContentSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.id == newItem.id
    }

}