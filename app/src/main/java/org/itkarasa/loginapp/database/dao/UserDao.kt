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
     * Insert an object in the database.
     *
     * @param user the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)

    /**
     * Delete an object from the database
     *
     * @param user the object to be deleted
     */
    @Delete
    abstract fun delete(user: User)


    @Query("select * FROM user_table")
    abstract fun getAll(): LiveData<List<User>>

    /**
     * get networkDevice by filtering the ip column
     * because there is not more than  device per ip, the output is a list with just one item
     *
     * @param username the ip of networkDevice
     */
    @Query("select * FROM user_table where username = :username")
    abstract fun get(username: String): List<User>
}