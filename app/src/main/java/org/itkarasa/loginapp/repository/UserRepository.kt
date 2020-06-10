package org.itkarasa.loginapp.repository

import org.itkarasa.loginapp.database.entity.User
import javax.inject.Inject

/**
 * Created by mohsen on 10,June,2020
 */
class UserRepository @Inject constructor(private val localDataSource: LocalDataSource){

    suspend fun getUsers() = localDataSource.getUsers()

    suspend fun getUser(username: String, password: String): User? = localDataSource.getUser(username, password)

    suspend fun insertUser(user: User): Boolean = localDataSource.insertUser(user)

    suspend fun updateUser(oldUser: User, user: User): Boolean = localDataSource.updateUser(oldUser, user)
    suspend fun updateUser(user: User): Boolean = localDataSource.updateUser(user)
    suspend fun deleteUser(user: User): Boolean = localDataSource.deleteUser(user)

}