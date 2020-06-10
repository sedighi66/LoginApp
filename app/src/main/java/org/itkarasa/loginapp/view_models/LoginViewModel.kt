package org.itkarasa.loginapp.view_models

import androidx.lifecycle.ViewModel
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject

/**
 * Created by mohsen on 10,June,2020
 */
class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

}