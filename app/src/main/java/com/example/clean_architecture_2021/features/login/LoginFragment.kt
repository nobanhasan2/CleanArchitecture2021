package com.example.clean_architecture_2021.features.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.clean_architecture_2021.core.auth.Authenticator
import com.example.clean_architecture_2021.core.navigation.Navigator
import com.example.clean_architecture_2021.core.platform.BaseVMFragment
import com.example.clean_architecture_2021.databinding.FragmentLoginBinding
import com.example.clean_architecture_2021.model.UserResult
import com.example.clean_architecture_2021.core.extension.failure
import com.example.clean_architecture_2021.core.extension.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseVMFragment<LoginViewModel,FragmentLoginBinding>() {

    @Inject
    lateinit var navigator: Navigator
    @Inject
    lateinit var authenticator: Authenticator

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(loginViewModel){
            observe(userResult,::onLoginSuccess)
            failure(failure,::handleFailure)
        }
        with(loginViewModel){
            observe(loadingStatus,::showProgressLoader)
        }
    }

    private fun onLoginSuccess(userResult: UserResult?) {
        authenticator.isLoggedIn = true
        navigator.showHome()
    }
    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)
}
