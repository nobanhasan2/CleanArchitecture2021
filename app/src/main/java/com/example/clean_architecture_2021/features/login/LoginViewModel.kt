package com.example.clean_architecture_2021.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_2021.core.platform.BaseViewModel
import com.example.clean_architecture_2021.features.login.domain.GetLogin
import com.example.clean_architecture_2021.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
        private val getLogin: GetLogin
): BaseViewModel(){

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> = _user

    fun login(username:String,password:String){
        getLogin(GetLogin.Params(username,password),viewModelScope){
            it.fold(
                    ::handleFailure,
                    ::handleOnSuccessLogin
            )
        }
    }

    private fun handleOnSuccessLogin(user: User) {
        _user.value = user
    }

}