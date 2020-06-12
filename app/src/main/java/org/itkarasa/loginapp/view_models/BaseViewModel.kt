package org.itkarasa.loginapp.view_models

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

/**
 * Created by mohsen on 11,June,2020
 */
abstract class BaseViewModel(private val context: Context)
    : ViewModel() {

    fun showMessage(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}