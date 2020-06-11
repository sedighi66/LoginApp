package org.itkarasa.loginapp.di.modules

import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.LoginApp
import org.itkarasa.loginapp.repository.UserRepository

// provide userRepository as a singleton
@Module
class UserRepositoryModule(private val loginApp: LoginApp) {

    @Provides
    fun provideUserRepository(): UserRepository {
        return loginApp.userRepository
    }
}
