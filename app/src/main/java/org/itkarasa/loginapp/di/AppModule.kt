package org.itkarasa.loginapp.di

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.LoginApp
import org.itkarasa.loginapp.database.AppDatabase
import org.itkarasa.loginapp.database.dao.UserDao

/**
 * Created by mohsen on 09,June,2020
 */
@Module
class AppModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideLoginApp(): LoginApp = activity.application as LoginApp

    @Provides
    fun provideApp(): Application = activity.application

    @Provides
    fun provideUserDao(context: Context): UserDao {
        return AppDatabase.getInstance(context)!!.userDao()
    }
}