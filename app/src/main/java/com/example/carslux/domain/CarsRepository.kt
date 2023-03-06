package com.example.carslux.domain

import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel

interface CarsRepository {

   suspend fun getCar()

   suspend fun showCar(): List<CarsModel>

   suspend fun deleteCar(id: Int)

   suspend fun findItemEntityById(id: Int): CarsModel

   suspend fun favClick(carsModel: CarsModel)

   suspend fun getFavorites(): List<FavoriteModel>
}