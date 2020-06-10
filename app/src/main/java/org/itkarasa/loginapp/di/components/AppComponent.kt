package org.itkarasa.loginapp.di.components

import dagger.Component
import org.itkarasa.loginapp.di.modules.AppModule
import org.itkarasa.loginapp.repository.UserRepository
import javax.inject.Singleton

/**
 * Created by mohsen on 06,June,2020
 *
 **/
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun userRepository(): UserRepository
}