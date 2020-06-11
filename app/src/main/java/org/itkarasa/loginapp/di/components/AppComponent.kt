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

    //UserRepository should be singleton, because in whole of the application it is usable
    fun userRepository(): UserRepository
}