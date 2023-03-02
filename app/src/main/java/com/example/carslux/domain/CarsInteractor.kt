package com.example.carslux.domain

import androidx.lifecycle.ViewModelProvider
import com.example.carslux.domain.model.CarsModel
import javax.inject.Inject

class CarsInteractor @Inject constructor(
    private val carsRepository: CarsRepository
) {

    suspend fun getCars() {
        return carsRepository.getCar()
    }

    suspend fun showCars(): List<CarsModel>{
        return carsRepository.showCar()
    }

    suspend fun deleteCar(id: Int){
         carsRepository.deleteCar(id)
    }

}