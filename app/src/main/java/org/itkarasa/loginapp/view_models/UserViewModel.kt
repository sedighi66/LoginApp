package org.itkarasa.loginapp.view_models

import android.content.Context
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.helpers.Validators
import org.itkarasa.loginapp.repository.UserRepository

/**
 * Created by mohsen on 10,June,2020
 */
abstract class UserViewModel(private val context: Context): BaseViewModel(context) {

    fun validate(username: String?): Boolean{

        if(username.isNullOrEmpty()){
            showMessage(context.getString(R.string.enter_email))
            return false
        }

        if(!Validators.isValidEmailAddress(username)) {
            showMessage(context.getString(R.string.valid_email))
            return false
        }
        return true
    }

    fun validate(
        username: String?,
        password: String?,
        passwordConfirm: String?
    ): Boolean {

        if(!validate(username)) return false

        if(password.isNullOrEmpty()){
            showMessage(context.getString(R.string.enter_values))
            return false
        }

        val passwordErrors = Validators.isPasswordValid(password, passwordConfirm)

        if(!passwordErrors.isNullOrEmpty()){
            showMessage(passwordErrors[0])
            return false
        }
        return true
    }
}