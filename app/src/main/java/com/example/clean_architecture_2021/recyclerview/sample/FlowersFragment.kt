package com.example.clean_architecture_2021.recyclerview.sample

import android.os.Bundle
import android.view.View
import com.example.clean_architecture_2021.core.platform.BaseFragment
import com.example.clean_architecture_2021.recyclerview.base.callback.ItemClickListener
import com.example.clean_architecture_2021.recyclerview.sample.data.Flower

class FlowersFragment : BaseFragment() {

    val flowersAdapter = FlowersAdapter()
    val flowerList: List<Flower> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Set Adapter Item Click Listener
         */
        flowersAdapter.setItemClickListener(object : ItemClickListener<Flower> {
            override fun onItemClick(view: View, item: Flower) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(view: View, item: Flower, position: Int) {
                TODO("Not yet implemented")
            }

        })

        /**
         * Set Adapter List
         */
        flowersAdapter.submitList(flowerList)
    }

}