package org.itkarasa.loginapp.repository

import androidx.lifecycle.LiveData
import org.itkarasa.loginapp.database.dao.UserDao
import org.itkarasa.loginapp.database.entity.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) {

    suspend fun getUsers(): LiveData<List<User>> = userDao.getAll()

    suspend fun getUser(username: String, password: String): User?{

        val users = userDao.getUser(username, password)
        return if(users.size == 1)
            users[0]
        else null
    }

    suspend fun insertUser(user: User): Boolean{

        val exist = userDao.getUser(user.username, user.password).isNotEmpty()
        return if(exist)
            false
        else{
            userDao.insert(user)
            true
        }
    }

    suspend fun updateUser(oldUser: User, user: User): Boolean{

        val databaseUser = getUser(oldUser.username, oldUser.password) ?: return false

        user.id = databaseUser.id
        userDao.update(user)

        return true
    }

    suspend fun updateUser(user: User): Boolean{
        val updatedRows = userDao.update(user)

        return updatedRows > 0
    }

    fun deleteUser(user: User): Boolean {
        val updatedRows = userDao.delete(user)

        return updatedRows > 0
    }
}
