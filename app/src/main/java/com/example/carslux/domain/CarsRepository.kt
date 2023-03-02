package com.example.carslux.domain

import com.example.carslux.domain.model.CarsModel

interface CarsRepository {

   suspend fun getCar()

   suspend fun showCar(): List<CarsModel>

   suspend fun deleteCar(id: Int)
}