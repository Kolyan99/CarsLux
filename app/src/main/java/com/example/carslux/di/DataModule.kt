package com.example.carslux.di

import com.example.carslux.data.CarsRepositoryImpl
import com.example.carslux.domain.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsCarsRepository(
        carsRepositoryImpl: CarsRepositoryImpl
    ): CarsRepository

}