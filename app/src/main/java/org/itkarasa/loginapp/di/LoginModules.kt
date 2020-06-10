package org.itkarasa.loginapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.database.AppDatabase
import org.itkarasa.loginapp.database.dao.UserDao

@Module
class LoginModules {

    @Provides
    fun provideUserDao(context: Context): UserDao {
        return AppDatabase.getInstance(context)!!.userDao()
    }
}
