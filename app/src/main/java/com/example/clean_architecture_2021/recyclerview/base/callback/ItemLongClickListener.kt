package com.example.clean_architecture_2021.recyclerview.base.callback

import android.view.View
import com.example.clean_architecture_2021.recyclerview.base.BaseAdapter

/**
 * This is a interface that contains callback methods to work with RecyclerView item long clicks
 * @author Tahsin Jawad
 * */
interface ItemLongClickListener<T> {
    /**
     * This method is called when an item gets long clicked.
     *
     * @param view clicked view
     * @param item model object
     */
    fun onItemLongClick(view: View, item: T)

    /**
     * This method is called when an item gets long clicked.
     *
     * @param view clicked view
     * @param item model object
     * @param position model object position in the list
     */
    fun onItemLongClick(view: View, item: T, position: Int)

    /**
     * This method sets this long click listener to the adapter
     *
     * @param adapter RecyclerView adapter
     * */
    fun setAdapter(adapter: BaseAdapter<T>) {
        adapter.setItemLongClickListener(this)
    }
}