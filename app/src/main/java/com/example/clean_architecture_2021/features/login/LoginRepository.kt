package com.example.clean_architecture_2021.features.login

import com.example.clean_architecture_2021.core.api.ApiRequest
import com.example.clean_architecture_2021.core.exception.Failure
import com.example.clean_architecture_2021.core.platform.NetworkHandler
import com.example.clean_architecture_2021.model.User
import com.fernandocejas.sample.core.functional.Either
import javax.inject.Inject


interface LoginRepository {
    fun login(username:String,password:String): Either<Failure,User>
    class Network
    @Inject constructor(
            private val networkHandler: NetworkHandler,
            private val service: LoginService
    ):LoginRepository,ApiRequest(){
        override fun login(username: String, password: String): Either<Failure, User> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                        service.login(username,password),
                        {it},
                        User()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }
    }
}