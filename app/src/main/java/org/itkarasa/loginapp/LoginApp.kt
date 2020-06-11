package org.itkarasa.loginapp

import android.app.Activity
import android.app.Application
import org.itkarasa.loginapp.di.components.DaggerAppComponent
import org.itkarasa.loginapp.di.modules.AppModule
import org.itkarasa.loginapp.repository.UserRepository

/**
 * Created by mohsen on 10,June,2020
 */
class LoginApp: Application() {
    lateinit var userRepository: UserRepository

    override fun onCreate() {
        super.onCreate()
        // userRepository is in whole of the app,
        // so it should be a singleton
        userRepository = DaggerAppComponent.builder().appModule(AppModule(this)).build().userRepository()
    }
}