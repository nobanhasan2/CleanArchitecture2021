package com.example.clean_architecture_2021.features.login

import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.core.platform.BaseFragment
import com.example.clean_architecture_2021.core.platform.BaseVMFragment
import com.example.clean_architecture_2021.databinding.FragmentLoginBinding

class LoginFragment : BaseVMFragment<LoginViewModel,FragmentLoginBinding>() {
    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)
}
