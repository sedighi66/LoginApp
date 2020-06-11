package org.itkarasa.loginapp.repository

import androidx.lifecycle.LiveData
import org.itkarasa.loginapp.database.dao.UserDao
import org.itkarasa.loginapp.database.entity.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) {

    fun getUsers(): LiveData<List<User>> = userDao.getAll()


    /**
     * this function is for validation of user in login page
     * it returns the user if it is in database, otherwise, it returns null.
     *
     * @param username the username of user
     * @param password the password of user
     */
    suspend fun getUser(username: String, password: String): User?{

        val users = userDao.getUser(username, password)
        return if(users.size == 1)
            users[0]
        else null
    }

    /**
     * this function is for checking is the username is in database before.
     * it returns the user if it is in database, otherwise, it returns null.
     *
     * @param username the username of user
     */
    suspend fun getUser(username: String): User?{

        val users = userDao.getUser(username)
        return if(users.size == 1)
            users[0]
        else null
    }

    /**
     * this function is for inserting user to database
     * if it is already exist, it returns false, otherwise after completing
     * the insertion, it returns true
     *
     * @param user the user to insert
     */
    suspend fun insertUser(user: User): Boolean{

        val exist = userDao.getUser(user.username).isNotEmpty()
        return if(exist)
            false
        else{
            userDao.insert(user)
            true
        }
    }

    /**
     * this function is for updating the user
     * First we get id of the user from database,
     * and then we put it with that id in other word updating the user.
     *
     * @param oldUser
     * @param user
     */
    suspend fun updateUser(oldUser: User, user: User): Boolean{

        val databaseUser = getUser(oldUser.username, oldUser.password) ?: return false

        user.id = databaseUser.id
        userDao.update(user)

        return true
    }


    /**
     * When the user is got from database before, and updated it,
     * can be used to update the user in database.
     *
     * @param user
     */
    suspend fun updateUser(user: User): Boolean{
        val updatedRows = userDao.update(user)

        return updatedRows > 0
    }


    /**
     * Delete a user form Database.
     * it returns false, when that user is not in there,
     * and returns true when there is.
     *
     * @param user
     */
    suspend fun deleteUser(user: User): Boolean {
        val updatedRows = userDao.delete(user)

        return updatedRows > 0
    }
}
