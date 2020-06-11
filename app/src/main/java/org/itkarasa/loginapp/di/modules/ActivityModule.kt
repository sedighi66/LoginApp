package org.itkarasa.loginapp.di.modules

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.LoginApp
import org.itkarasa.loginapp.database.AppDatabase
import org.itkarasa.loginapp.database.dao.UserDao

/**
 * Created by mohsen on 09,June,2020
 */
// According to what we need in app, we provide these items by using app or activity as the constructor argument of the module
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideLoginApp(): LoginApp = activity.application as LoginApp

    @Provides
    fun provideApp(): Application = activity.application
}