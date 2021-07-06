package com.example.clean_architecture_2021

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.clean_architecture_2021.core.navigation.Navigator
import com.example.clean_architecture_2021.core.platform.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) { setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        val navigationHost =  supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navigation.init(navigationHost)
        setSupportActionBar(toolbar)
        navigationHost.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }

    }
}