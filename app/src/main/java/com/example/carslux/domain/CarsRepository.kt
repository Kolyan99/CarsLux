package com.example.carslux.domain

import com.example.carslux.domain.model.CarsModel

interface CarsRepository {

   suspend fun getCar(): List<CarsModel>
}