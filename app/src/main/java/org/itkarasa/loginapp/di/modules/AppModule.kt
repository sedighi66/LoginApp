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
@Module
class AppModule(private val app: Application) {

    @Provides
    fun provideContext(): Context = app.applicationContext

    @Provides
    fun provideLoginApp(): LoginApp = app as LoginApp

    @Provides
    fun provideApp(): Application = app

    @Provides
    fun provideUserDao(context: Context): UserDao {
        return AppDatabase.getInstance(context)!!.userDao()
    }
}