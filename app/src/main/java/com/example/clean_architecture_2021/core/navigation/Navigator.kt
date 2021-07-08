package com.example.clean_architecture_2021.core.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.core.auth.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class  Navigator  @Inject constructor(private val authenticator: Authenticator) {

    lateinit var navController : NavController

    fun init(navHostFragment:NavHostFragment){
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)


        if (authenticator.userLoggedIn()){ graph.startDestination = R.id.homeFragment
        }else { graph.startDestination = R.id.loginFragment }

        navController = navHostFragment.navController
        navController.graph = graph

    }

    /**
     * This function is for authenticate the routing if the user is loged in
     * Then go to the Destination otherwise it will redirect to Login
     */
    private fun authNavigate(navigateID: Int) {
        if (authenticator.userLoggedIn()){ navController.navigate(navigateID) }

        else{ navController.navigate(R.id.loginFragment) }
    }

    /**
     * All Destination path method called from XML @see in the layout
     */
    fun showHome(){ authNavigate(R.id.action_signIn_to_Home) }

    fun showSignUp(){ navController.navigate(R.id.homeFragment) }
}