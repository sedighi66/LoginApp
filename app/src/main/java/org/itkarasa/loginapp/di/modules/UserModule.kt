package org.itkarasa.loginapp.di.modules

import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.database.entity.User

@Module
class UserModule(private val user: User) {

    @Provides
    fun provideUser(): User{
        return user
    }
}
