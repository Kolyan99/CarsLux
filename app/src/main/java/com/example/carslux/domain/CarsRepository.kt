package com.example.carslux.domain

import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel
import kotlinx.coroutines.flow.Flow

interface CarsRepository {

   suspend fun getCar()

   suspend fun showCar(): Flow<List<CarsModel>>

   suspend fun deleteCar(id: Int)

   suspend fun findItemEntityById(id: Int): CarsModel

   suspend fun favClick(carsModel: CarsModel)

   suspend fun getFavorites(): Flow<List<FavoriteModel>>

   suspend fun deleteFavorite(id: Int)
}