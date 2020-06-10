package org.itkarasa.loginapp.di

import dagger.Component
import org.itkarasa.loginapp.view_models.ProfileViewModel
import org.itkarasa.loginapp.view_models.SignupViewModel

/**
 * Created by mohsen on 10,June,2020
 */
@Component(modules = [AppModule::class, ProfileModule::class])
interface ProfileComponent {

    fun profileViewModel(): ProfileViewModel
}