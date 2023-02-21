package com.example.carslux.domain

import androidx.lifecycle.ViewModelProvider
import com.example.carslux.domain.model.CarsModel
import javax.inject.Inject

class CarsInteractor @Inject constructor(
    private val carsRepository: CarsRepository
) {

    fun getCars(): List<CarsModel> {
        return carsRepository.getCar()
    }
}