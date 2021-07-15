package com.example.clean_architecture_2021.core.platform

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.clean_architecture_2021.R
import com.example.clean_architecture_2021.core.exception.Failure
import com.example.clean_architecture_2021.core.extension.close
import com.example.clean_architecture_2021.core.extension.viewContainer
import com.example.clean_architecture_2021.core.navigation.Navigator

import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_layout.*
import javax.inject.Inject

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var navigation: Navigator
    open fun onBackPressed() {  }

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    private fun showProgress() = progressStatus(View.VISIBLE)

    private fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }

    fun showProgressLoader(b: Boolean?) {
        when(b){
            true  ->{ showProgress()}
            false ->{ hideProgress()}
        }
    }

    private fun notify(@StringRes message: Int) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> {
                notify(R.string.failure_network_connection); close()
            }
            is Failure.ServerError -> {
                notify(R.string.failure_server_error); close()
            }
            else -> {
                notify(R.string.failure_server_error); close()
            }
        }
    }
    internal fun notifyWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.show()
    }
}
