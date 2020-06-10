package org.itkarasa.loginapp.view_models

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject
import org.itkarasa.loginapp.database.entity.User

/**
 * Created by mohsen on 10,June,2020
 */
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context,
    var user: User
) : UserViewModel(userRepository, context) {

    fun delete() {

        CoroutineScope(Dispatchers.IO).launch {
            val isDeleted = userRepository.deleteUser(user)
            withContext(Dispatchers.Main){
                if(isDeleted) {
                    showMessage("Deleted.")
                    //TODO
                    (context as AppCompatActivity).onBackPressed()
                }
                else
                    showMessage("Not Deleted.")
            }
        }
    }


    fun update() {

        if(!validate(user.username)) return

        CoroutineScope(Dispatchers.IO).launch {
            val isUpdated = userRepository.updateUser(user)
            withContext(Dispatchers.Main){
                if(isUpdated)
                    showMessage("Updated.")
                else
                    showMessage("Not Updated.")
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