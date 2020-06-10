package org.itkarasa.loginapp.di

import androidx.appcompat.app.AppCompatActivity
import org.itkarasa.loginapp.LoginApp
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.di.components.*
import org.itkarasa.loginapp.di.modules.ActivityModule
import org.itkarasa.loginapp.di.modules.UserModule
import org.itkarasa.loginapp.di.modules.UserRepositoryModule
import org.itkarasa.loginapp.view_models.*

/**
 * Created by mohsen on 11,June,2020
 */
object DiHelper {

    fun getAdminViewModel(activity: AppCompatActivity): AdminViewModel =
        DaggerAdminComponent.builder().activityModule(
        ActivityModule(activity)
        ).userRepositoryModule(UserRepositoryModule(activity.application as LoginApp))
        .build().adminViewModel()

    fun getLoginViewModel(activity: AppCompatActivity): LoginViewModel =
        DaggerLoginComponent.builder().activityModule(
        ActivityModule(activity)).userRepositoryModule(UserRepositoryModule(activity.application as LoginApp))
        .build().loginViewModel()

    fun getProfileViewModel(activity: AppCompatActivity, user: User): ProfileViewModel =
        DaggerProfileComponent.builder().activityModule(
        ActivityModule(activity))
        .userModule(UserModule(user))
        .userRepositoryModule(UserRepositoryModule(activity.application as LoginApp))
        .build().profileViewModel()

    fun getProfileWatchViewModel(activity: AppCompatActivity, user: User): ProfileWatchViewModel =
        DaggerProfileWatchComponent.builder().activityModule(
        ActivityModule(activity))
        .userModule(UserModule(user))
        .userRepositoryModule(UserRepositoryModule(activity.application as LoginApp))
        .build().profileWatchViewModel()

    fun getSignupViewModel(activity: AppCompatActivity): SignupViewModel =
        DaggerSignupComponent.builder().activityModule(
        ActivityModule(activity))
        .userRepositoryModule(UserRepositoryModule(activity.application as LoginApp))
        .build().signUpViewModel()

}