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
import android.view.View

/**
 * Created by mohsen on 10,June,2020
 */
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : ViewModel() {


    fun login(username: String?, password: String?) {

        if(password.isNullOrEmpty() || username.isNullOrEmpty()) {
            showMessage("Please enter username and password.")
            return
        }

            CoroutineScope(Dispatchers.IO).launch {
            val user = userRepository.getUser(username, password)

            withContext(Dispatchers.Main) {
                if (user == null)
                    showMessage("You are not signed Up before. Please sign up first.")
                else {
                    if(user.isAdmin){
                        //TODO
                        //go to admin users page
                    }
                    else {
                        //TODO
                     //   go to user profile page
                    }
                }

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