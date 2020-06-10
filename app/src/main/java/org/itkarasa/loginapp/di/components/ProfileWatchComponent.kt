package org.itkarasa.loginapp.di.components

import dagger.Component
import org.itkarasa.loginapp.di.modules.ActivityModule
import org.itkarasa.loginapp.di.modules.UserModule
import org.itkarasa.loginapp.di.modules.UserRepositoryModule
import org.itkarasa.loginapp.view_models.ProfileWatchViewModel

/**
 * Created by mohsen on 10,June,2020
 */
@Component(modules = [ActivityModule::class, UserModule::class, UserRepositoryModule::class])
interface ProfileWatchComponent {

    fun profileWatchViewModel(): ProfileWatchViewModel
}