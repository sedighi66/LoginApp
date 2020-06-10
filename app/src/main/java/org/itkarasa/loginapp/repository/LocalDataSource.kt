package org.itkarasa.loginapp.repository

import org.itkarasa.loginapp.database.dao.UserDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) {

}
