package org.itkarasa.loginapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.database.AppDatabase
import org.itkarasa.loginapp.database.dao.UserDao
import org.itkarasa.loginapp.database.entity.User

@Module
class ProfileModule(private val user: User) {

    @Provides
    fun provideUser(): User{
        return user
    }
}
