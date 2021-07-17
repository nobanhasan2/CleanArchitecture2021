package com.example.clean_architecture_2021.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean_architecture_2021.BR
import java.lang.reflect.ParameterizedType
/**
 * BaseVMFragment for binding the viewModel and Data binding class
 */
abstract class BaseVMFragment <VM : ViewModel, B : ViewDataBinding> : BaseFragment(){
    lateinit var mViewModel: VM
    lateinit var mBinding: B
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewModel = ViewModelProvider(this).get(getViewModelClass())
        mBinding = getViewBinding()
        mBinding.lifecycleOwner = this
        mBinding.setVariable(BR.navigator,navigation)
        mBinding.setVariable(BR.viewModel,mViewModel)
        return mBinding.root
    }
    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }
    abstract fun getViewBinding(): B
}