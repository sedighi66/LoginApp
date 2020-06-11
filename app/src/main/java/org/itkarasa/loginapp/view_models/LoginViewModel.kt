package org.itkarasa.loginapp.view_models

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.repository.UserRepository
import org.itkarasa.loginapp.ui.AdminActivity
import org.itkarasa.loginapp.ui.ProfileActivity
import org.itkarasa.loginapp.ui.SignupActivity
import javax.inject.Inject

/**
 * Created by mohsen on 10,June,2020
 */
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : BaseViewModel(context) {


    fun signUp(view: View) {
        val intent = Intent(context, SignupActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(context, intent, null)
    }

    fun login(username: String?, password: String?) {

        if (password.isNullOrEmpty() || username.isNullOrEmpty()) {
            showMessage(context.getString(R.string.enter_values))
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            var user = userRepository.getUser(username)


            if (user == null) {
                withContext(Dispatchers.Main) {
                    showMessage("You are not signed Up before. Please sign up first.")
                }
                return@launch
            } else {

                user = userRepository.getUser(username, password)
                if (user == null) {
                    withContext(Dispatchers.Main) {
                        showMessage("Your password is not correct.")
                    }
                    return@launch
                }

                if (user.isAdmin) {
                    val intent = Intent(context, AdminActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(context, intent, null)
                } else {
                    val intent = Intent(context, ProfileActivity::class.java)
                    intent.putExtra(USER_KEY, user)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(context, intent, null)
                }

            }
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
        const val USER_KEY = "user"
    }
}