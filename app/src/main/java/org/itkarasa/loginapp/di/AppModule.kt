package org.itkarasa.loginapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.itkarasa.loginapp.LoginApp

/**
 * Created by mohsen on 09,June,2020
 */
@Module(includes = [LoginModules::class])
class AppModule(private val app: LoginApp) {

    @Provides
    fun provideContext(): Context = app.applicationContext

    @Provides
    fun provideLoginApp(): LoginApp = app

    @Provides
    fun provideApp(): Application = app
}