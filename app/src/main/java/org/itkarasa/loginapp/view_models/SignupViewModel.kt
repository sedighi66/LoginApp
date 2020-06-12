package org.itkarasa.loginapp.view_models

import android.content.Context
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Inject
import androidx.databinding.ObservableField

/**
 * Created by mohsen on 10,June,2020
 */
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val context: Context
) : UserViewModel(userRepository, context){

    val fullName = ObservableField<String>()
    val username = ObservableField<String>()
    val password = ObservableField<String>()
    val confirmPassword = ObservableField<String>()

    fun signUp() =
        signUp(username.get(), password.get(), confirmPassword.get(), fullName.get())

}