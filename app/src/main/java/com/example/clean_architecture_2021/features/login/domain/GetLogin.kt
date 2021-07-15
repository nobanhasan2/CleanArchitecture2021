package com.example.clean_architecture_2021.features.login.domain

import com.example.clean_architecture_2021.core.interactor.UseCase
import com.example.clean_architecture_2021.features.login.LoginRepository
import com.example.clean_architecture_2021.features.login.domain.GetLogin.Params
import com.example.clean_architecture_2021.model.User
import javax.inject.Inject

class GetLogin @Inject constructor(private val loginRepository: LoginRepository): UseCase<User, Params>(){

    data class Params(val username: String,val password:String)

    override suspend fun run(params: Params) = loginRepository.login(params.username,params.password)
}