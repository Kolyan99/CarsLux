package com.example.carslux.di

import com.example.carslux.data.repository.CarsRepositoryImpl
import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsCarsRepository(
        carsRepositoryImpl: CarsRepositoryImpl
    ): CarsRepository


    companion object {
        private const val BASE_URL = "https://api.jsonserve.com"

        @Provides
        fun providesApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}