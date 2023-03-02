package com.example.carslux.di

import android.content.Context
import com.example.carslux.data.database.dao.CarsDao
import com.example.carslux.data.database.dao.CarsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideCarsDao(carsDataBase: CarsDataBase): CarsDao {
        return carsDataBase.getCarsDAO()
    }

    @Provides
    fun carsDatabase(context: Context): CarsDataBase {
        return CarsDataBase.getItemsDatabaseInstance(context)
    }
}