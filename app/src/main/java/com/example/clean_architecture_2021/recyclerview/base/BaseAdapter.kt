package com.example.clean_architecture_2021.recyclerview.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.clean_architecture_2021.recyclerview.base.callback.ItemClickListener
import com.example.clean_architecture_2021.recyclerview.base.callback.ItemLongClickListener

/**
 * This is base adapter class which will be extended for creating next RecyclerView adapters
 * @author Tahsin Jawad
 */
abstract class BaseAdapter<T>(itemCallback: BaseItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<T>>(itemCallback) {

    protected var mItemClickListener: ItemClickListener<T>? = null
    protected var mItemLongClickListener: ItemLongClickListener<T>? = null


    /**
     * This method sets item click listener
     *
     * @param listener item click listener
     */
    fun setItemClickListener(listener: ItemClickListener<T>) {
        this.mItemClickListener = listener
    }

    /**
     * This method sets item long click listener
     *
     * @param listener item long click listener
     */
    fun setItemLongClickListener(listener: ItemLongClickListener<T>) {
        this.mItemLongClickListener = listener
    }

    /**
     * This method prepares a new view holder for the item
     *
     * @param parent parent ViewGroup
     * @param viewType type of the view
     * @return [BaseViewHolder] a new view holder
     */
    abstract fun newViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    /**
     * This method creates a new view holder for the item
     *
     * @param parent parent ViewGroup
     * @param viewType type of the view
     * @return [BaseViewHolder] a new view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return newViewHolder(parent, viewType)
    }

    /**
     * This method binds the item data to the view holder
     *
     * @param holder item view holder
     * @param position adapter position
     */
    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }


    /**
     * This method provides a data binding object
     *
     * @param parent parent ViewGroup
     * @param itemLayout layout id of the item
     * @return [ViewDataBinding] data binding object
     */
    fun <B : ViewDataBinding> inflate(parent: ViewGroup, @LayoutRes itemLayout: Int): B {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            itemLayout,
            parent,
            false)
    }

}