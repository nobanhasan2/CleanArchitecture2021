package com.example.clean_architecture_2021.features.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_2021.AndroidApplication
import com.example.clean_architecture_2021.AppConstants
import com.example.clean_architecture_2021.core.di.ApplicationModule
import com.example.clean_architecture_2021.core.platform.BaseViewModel
import com.example.clean_architecture_2021.features.login.domain.GetLogin
import com.example.clean_architecture_2021.model.UserResult
import com.example.clean_architecture_2021.util.PreferenceUtil
import com.example.clean_architecture_2021.util.validator.FieldValidate
import com.example.clean_architecture_2021.util.validator.LiveDataValidatorResolver
import com.example.clean_architecture_2021.util.validator.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
        private val getLogin: GetLogin,

): BaseViewModel(){

    private val _userResult: MutableLiveData<UserResult> = MutableLiveData()
    val userResult: LiveData<UserResult> = _userResult
    val usernameLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val usernameValidator = Validator.inputFieldValidate(FieldValidate.TEXT.name,usernameLiveData)
    val passwordValidator = Validator.inputFieldValidate(FieldValidate.PASSWORD.name,passwordLiveData)
    val isLoginFormValidMediator = MediatorLiveData<Boolean>()

    init {
        isLoginFormValidMediator.value = false
        isLoginFormValidMediator.addSource(usernameLiveData) { validateForm() }
        isLoginFormValidMediator.addSource(passwordLiveData) { validateForm() }
    }
    fun login(username:String,password:String){
        loadingStatus.value = true
        getLogin(GetLogin.Params(username,password),viewModelScope){
            it.fold(::handleFailure, ::handleOnSuccessLogin)
        }
    }

    private fun handleOnSuccessLogin(userResult: UserResult) {
        loadingStatus.value = false
        _userResult.value = userResult

    }
    private fun validateForm() {
        val validators = listOf(usernameValidator, passwordValidator)
        val validatorResolver = LiveDataValidatorResolver(validators)
        isLoginFormValidMediator.value = validatorResolver.isValid()
    }

}