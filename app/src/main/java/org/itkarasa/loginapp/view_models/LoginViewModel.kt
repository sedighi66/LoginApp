package org.itkarasa.loginapp.view_models

import androidx.lifecycle.ViewModel
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject

/**
 * Created by mohsen on 10,June,2020
 */
class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    suspend fun isAdmin(user: User): Boolean{

        val authUser = userRepository.getUser(user.username, user.password) ?: return false
        return authUser.isAdmin
    }

    private suspend fun signUp(username: String, password: String, fullName: String?): Boolean =
        userRepository.insertUser(User(username, password, fullName))

    private suspend fun signIn(username: String, password: String): User?{
        return userRepository.getUser(username, password)
    }

}