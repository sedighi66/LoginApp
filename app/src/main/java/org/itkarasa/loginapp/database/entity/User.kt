package org.itkarasa.loginapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by mohsen on 03,May,2020
 */
@Entity(tableName = "user_table")
data class User(
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "full_name")
    var fullName: String? = null
) : Serializable{                       //serialize user to pass it between activities
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var id: Int = 0

    @ColumnInfo(name = "is_admin")
    var isAdmin: Boolean = false
}


