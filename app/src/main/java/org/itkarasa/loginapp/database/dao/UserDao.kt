package org.itkarasa.loginapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.itkarasa.loginapp.database.entity.User

/**
 * Created by mohsen on 03,May,2020
 */
@Dao
abstract class UserDao {

    /**
     * Insert an object on the database
     *
     * @param user the object to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)

    /**
     * update an object on the database
     *
     * @param user the object to be updated
     */
    @Update
    abstract fun update(user: User): Int

    /**
     * Delete an object from the database
     *
     * @param user the object to be deleted
     */
    @Delete
    abstract fun delete(user: User): Int

    /**
     * get users by filtering username field
     *
     * @param username the username of user
     */
    @Query("select * FROM user_table where username = :username")
    abstract fun getUser(username: String): List<User>

    /**
     * get users by filtering username and password field
     *
     * @param username the username of user
     * @param password the password of user
     */
    @Query("select * FROM user_table where username = :username AND password = :password")
    abstract fun getUser(username: String, password: String): List<User>


    /**
     * get all users
     *
     */
    @Query("select * FROM user_table")
    abstract fun getAll(): LiveData<List<User>>
}