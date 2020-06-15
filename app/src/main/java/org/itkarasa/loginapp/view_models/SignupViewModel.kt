package org.itkarasa.loginapp.view_models

import android.content.Context
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject
import androidx.databinding.ObservableField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.database.entity.User

/**
 * Created by mohsen on 10,June,2020
 */
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : UserViewModel(context){

    val fullName = ObservableField<String>()
    val username = ObservableField<String>()
    val password = ObservableField<String>()
    val confirmPassword = ObservableField<String>()

    fun signUp() {

        if(!validate(username.get(), password.get(), confirmPassword.get())) return

        CoroutineScope(Dispatchers.IO).launch {
            val success = userRepository.insertUser(User(username.get()!!, password.get()!!, fullName.get()))
            withContext(Dispatchers.Main) {
                if (success)
                    showMessage(context.getString(R.string.sign_up_message_success))
                else
                    showMessage( context.getString(R.string.sign_up_message_failed))
            }
        }
    }
}