package org.itkarasa.loginapp.di.modules

import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.database.entity.User

@Module
class UserModule(private val user: User) {

    // when user is passed from one activity to another, it is needed to tell dagger how to get the user object
    @Provides
    fun provideUser(): User{
        return user
    }
}
