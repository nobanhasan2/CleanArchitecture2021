package com.example.clean_architecture_2021.core.auth

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor() {
    //Learning purpose: We assume the user is always logged in
    //Here you should put your own logic to return whether the user
    //is authenticated or not
    fun userLoggedIn() = false
}
