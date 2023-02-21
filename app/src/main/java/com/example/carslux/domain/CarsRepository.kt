package com.example.carslux.domain

import com.example.carslux.domain.model.CarsModel

interface CarsRepository {

    fun getCar(): List<CarsModel>
}