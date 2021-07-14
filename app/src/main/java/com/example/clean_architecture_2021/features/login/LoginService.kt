package com.example.clean_architecture_2021.features.login

import com.example.clean_architecture_2021.model.User
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginService
@Inject constructor(retrofit: Retrofit) : LoginApi{
    private val loginApi by lazy { retrofit.create(LoginApi::class.java) }
    override fun login(userName: String, password: String) =loginApi.login(userName,password)
}