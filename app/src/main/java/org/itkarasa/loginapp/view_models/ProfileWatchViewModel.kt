package org.itkarasa.loginapp.view_models

import android.content.Context
import javax.inject.Inject
import org.itkarasa.loginapp.database.entity.User

/**
 * Created by mohsen on 10,June,2020
 */
class ProfileWatchViewModel @Inject constructor(private val context: Context,
    var user: User
) : BaseViewModel(context)