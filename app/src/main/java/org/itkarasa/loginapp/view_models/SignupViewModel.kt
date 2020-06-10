package org.itkarasa.loginapp.view_models

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.helpers.Validators

/**
 * Created by mohsen on 10,June,2020
 */
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : ViewModel() {

    fun signUp(username: String?, password: String?, passwordConfirm: String?, fullName: String?) {
        
        if(username.isNullOrEmpty() || password.isNullOrEmpty()  || passwordConfirm.isNullOrEmpty()){
            showMessage(context.getString(R.string.enter_values))
            return
        }
        
        if(!Validators.isValidEmailAddress(username)) {
            showMessage(context.getString(R.string.valid_email))
            return
        }
        
        val passwordErrors = Validators.isPasswordValid(password, passwordConfirm)

        if(!passwordErrors.isNullOrEmpty()){
            showMessage(passwordErrors[0])
            return
        }


        CoroutineScope(Dispatchers.IO).launch {
            val success = userRepository.insertUser(User(username, password, fullName))
            withContext(Dispatchers.Main) {
                if (success)
                    showMessage(context.getString(R.string.sign_up_message_success))
                else
                    showMessage( context.getString(R.string.sign_up_message_failed))
            }
        }
    }

    private fun showMessage(message: String){
        Log.d(TAG, "show message: message")
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object{
        private const val TAG = "LoginViewModel"
    }
}