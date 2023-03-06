package com.example.carslux.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carslux.data.database.CarsEntity

@Database(entities = [CarsEntity::class, FavoritesEntity::class], version = 1, exportSchema = false)
abstract class CarsDataBase: RoomDatabase() {

    abstract fun getCarsDAO(): CarsDao

    companion object{
        private const val DATABASE_NAME = "database_name"
        private var DATABASE_INSTANCE: CarsDataBase? = null

        fun getItemsDatabaseInstance(context: Context): CarsDataBase{
            return DATABASE_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    CarsDataBase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DATABASE_INSTANCE = it }
        }
    }
}