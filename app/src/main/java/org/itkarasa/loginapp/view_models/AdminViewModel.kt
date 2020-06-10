package org.itkarasa.loginapp.view_models

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
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
class AdminViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : UserViewModel(userRepository, context) {

    fun getUsers(): LiveData<List<User>> = userRepository.getUsers()

    companion object{
        private const val TAG = "LoginViewModel"
    }
}