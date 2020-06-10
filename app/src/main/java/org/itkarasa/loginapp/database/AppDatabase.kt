package org.itkarasa.loginapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.itkarasa.loginapp.database.dao.UserDao
import org.itkarasa.loginapp.database.entity.User

/**
 * Created by mohsen on 03,May,2020
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "database.db"
                    )
                        .fallbackToDestructiveMigration() // delete all database and
                        // start new when version of database has increased.
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbWithExecutor(instance)
                    .execute()
            }
        }
    }

    class PopulateDbWithExecutor(db: AppDatabase?) {

        private val userDao = db?.userDao()

        fun execute() {

            CoroutineScope(Dispatchers.IO).launch {
                userDao?.insert(
                    User(
                        "admin@admin.com", "Admin1234"
                    )
                )
            }
        }
    }
}