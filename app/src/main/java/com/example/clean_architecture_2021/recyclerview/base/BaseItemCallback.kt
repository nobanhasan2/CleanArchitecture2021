package com.example.clean_architecture_2021.recyclerview.base

import androidx.recyclerview.widget.DiffUtil

/**
 * This is base DiffUtil.ItemCallback class which will be extended for creating next Diff
 * @author Tahsin Jawad
 */
abstract class BaseItemCallback<T> : DiffUtil.ItemCallback<T>() {


    /**
     * This method check between two item
     *
     * @param oldItem old item
     * @param newItem new item
     * @return [Boolean]
     */
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }


    /**
     * This method check content between two item
     *
     * @param oldItem old item
     * @param newItem new item
     * @return [Boolean]
     */
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areContentSame(oldItem, newItem)
    }

    /**
     * This method check content between two item
     *
     * @param oldItem old item
     * @param newItem new item
     * @return [Boolean]
     */
    abstract fun areContentSame(oldItem: T, newItem: T): Boolean

}