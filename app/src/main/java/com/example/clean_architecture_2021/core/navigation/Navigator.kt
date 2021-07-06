package com.example.clean_architecture_2021.core.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.core.auth.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class  Navigator @Inject constructor(private val authenticator: Authenticator) {
    private lateinit var navController : NavController
    fun init(navHostFragment:NavHostFragment){
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        if (authenticator.userLoggedIn()){ graph.startDestination = R.id.homeFragment
        }else { graph.startDestination = R.id.loginFragment }

        navController = navHostFragment.navController
        navController.graph = graph

    }
    fun showHome(){
        navController.navigate(R.id.homeFragment)
    }
}