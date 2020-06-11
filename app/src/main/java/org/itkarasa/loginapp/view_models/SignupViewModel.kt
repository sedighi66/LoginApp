package org.itkarasa.loginapp.view_models

import android.content.Context
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject
import android.view.View

/**
 * Created by mohsen on 10,June,2020
 */
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : UserViewModel(userRepository, context)