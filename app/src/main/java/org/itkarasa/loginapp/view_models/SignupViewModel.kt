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
) : UserViewModel(userRepository, context) {

}