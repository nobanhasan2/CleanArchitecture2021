package com.example.clean_architecture_2021.features.login

import com.example.clean_architecture_2021.core.interactor.UseCase
import com.example.clean_architecture_2021.features.login.LoginUseCase.Params
import com.example.clean_architecture_2021.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository): UseCase<User, Params>(){

    data class Params(val username: String,val password:String)

    override suspend fun run(params: Params) = loginRepository.login(params.username,params.password)
}