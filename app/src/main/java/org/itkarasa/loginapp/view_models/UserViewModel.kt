package org.itkarasa.loginapp.view_models

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.helpers.Validators
import org.itkarasa.loginapp.repository.UserRepository

/**
 * Created by mohsen on 10,June,2020
 */
abstract class UserViewModel(private val userRepository: UserRepository,
                    private val context: Context): BaseViewModel(context) {

    fun signUp(username: String?, password: String?, passwordConfirm: String?, fullName: String?) {

        if(!validate(username, password, passwordConfirm)) return

        CoroutineScope(Dispatchers.IO).launch {
            val success = userRepository.insertUser(User(username!!, password!!, fullName))
            withContext(Dispatchers.Main) {
                if (success)
                    showMessage(context.getString(R.string.sign_up_message_success))
                else
                    showMessage( context.getString(R.string.sign_up_message_failed))
            }
        }
    }

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