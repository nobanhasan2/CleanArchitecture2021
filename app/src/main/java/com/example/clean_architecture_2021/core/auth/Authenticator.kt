package com.example.clean_architecture_2021.core.auth

import android.content.SharedPreferences
import com.example.clean_architecture_2021.AppConstants
import com.example.clean_architecture_2021.util.PreferenceUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor() {
    //Learning purpose: We assume the user is always logged in
    //Here you should put your own logic to return whether the user
    //is authenticated or not
    var isLogin = false

    fun  userLoggedIn() = PreferenceUtil<Boolean>().get(AppConstants.IS_LOGED_IN, defaultValue = false)
}
