package com.example.clean_architecture_2021.features.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.clean_architecture_2021.core.auth.Authenticator
import com.example.clean_architecture_2021.core.navigation.Navigator
import com.example.clean_architecture_2021.core.platform.BaseVMFragment
import com.example.clean_architecture_2021.databinding.FragmentLoginBinding
import com.example.clean_architecture_2021.model.User
import com.fernandocejas.sample.core.extension.failure
import com.fernandocejas.sample.core.extension.observe
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
            observe(user,::onLoginSuccess)
            failure(failure,::handleFailure)
        }
        loginViewModel.login("resmaccdb.fo@gmail.com","123")
    }

    private fun onLoginSuccess(user: User?) {
        authenticator.isLoggedIn = true
        navigator.showHome()
    }
    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)
}
