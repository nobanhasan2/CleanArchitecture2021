package com.example.clean_architecture_2021.features.login

import com.example.clean_architecture_2021.model.User
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {
    companion object {
        private const val LOGIN = "api/Authentication/LoginAppUser"
        const val KEY_USER_NAME = "username"
        const val KEY_PASSWORD = "password"
    }
    @POST(LOGIN)
    fun login(@Query(KEY_USER_NAME) userName: String, @Query(KEY_PASSWORD) password: String): Call<User>
}