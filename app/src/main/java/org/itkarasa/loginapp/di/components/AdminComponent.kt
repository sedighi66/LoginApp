package org.itkarasa.loginapp.di.components

import dagger.Component
import org.itkarasa.loginapp.di.Modules.AppModule
import org.itkarasa.loginapp.view_models.AdminViewModel

/**
 * Created by mohsen on 10,June,2020
 */
@Component(modules = [AppModule::class])
interface AdminComponent {

    fun adminViewModel(): AdminViewModel
}