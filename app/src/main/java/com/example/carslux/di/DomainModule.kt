package com.example.carslux.di

import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.CarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideCarsInteractor(
        carsRepository: CarsRepository
    ) : CarsInteractor{
        return CarsInteractor(carsRepository)
    }
}