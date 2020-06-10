package org.itkarasa.loginapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by mohsen on 03,May,2020
 */
@Entity(tableName = "user_table")
data class User(
    var username: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false
        if (password != other.password) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + id
        return result
    }


}


