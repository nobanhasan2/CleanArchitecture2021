package com.example.clean_architecture_2021.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.NavInflater

import androidx.navigation.fragment.NavHostFragment
import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.core.navigation.Navigator
import com.example.clean_architecture_2021.features.login.Authenticator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject


/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var navigation: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
    }

}
