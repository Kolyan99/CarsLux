package com.example.carslux.domain

import androidx.lifecycle.ViewModelProvider
import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarsInteractor @Inject constructor(
    private val carsRepository: CarsRepository
) {

    suspend fun getCars() {
        return carsRepository.getCar()
    }

    suspend fun showCars(): Flow<List<CarsModel>>{
        return carsRepository.showCar()
    }

    suspend fun deleteCar(id: Int){
         carsRepository.deleteCar(id)
    }


    suspend fun findItemEntityById(id: Int){
        carsRepository.findItemEntityById(id)
    }

    suspend fun onFavClick(id: Int){
        val foundItem = carsRepository.findItemEntityById(id)
        carsRepository.favClick(foundItem)
    }

    suspend fun getFavorites(): Flow<List<FavoriteModel>>{
        return carsRepository.getFavorites()
    }

    suspend fun deleteFavorite(id: Int){
        carsRepository.deleteFavorite(id)
    }

}