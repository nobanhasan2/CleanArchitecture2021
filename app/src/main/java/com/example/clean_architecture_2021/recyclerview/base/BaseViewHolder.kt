package com.example.clean_architecture_2021.recyclerview.base

import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * This is base view holder class which will be extended for creating next RecyclerView view holders
 * @author Tahsin Jawad
 */
abstract class BaseViewHolder<T>(binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {


    /**
     * Initializer block
     */
    init {
        binding.executePendingBindings()
    }

    /**
     * This method binds the item to item layout
     *
     * @param item model object
     */
    abstract fun bind(@NonNull item: T)


    /**
     * To set click listener on any view, You can pass multiple view at a time
     *
     * @param views View as params
     */
    protected fun setClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    /**
     * This method is fired upon clicking on any view of the item layout
     *
     * @param view clicked view
     */
    override fun onClick(view: View) {

    }

}