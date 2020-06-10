package org.itkarasa.loginapp.di.components

import dagger.Component
import org.itkarasa.loginapp.di.modules.ActivityModule
import org.itkarasa.loginapp.di.modules.UserRepositoryModule
import org.itkarasa.loginapp.view_models.LoginViewModel

/**
 * Created by mohsen on 10,June,2020
 */
@Component(modules = [ActivityModule::class, UserRepositoryModule::class])
interface LoginComponent {

    fun loginViewModel(): LoginViewModel
}