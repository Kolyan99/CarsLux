package com.example.carslux.data

import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CarsRepository {

    override suspend fun getCar(): List<CarsModel> {
      return withContext(Dispatchers.IO){
            val response = apiService.getCar()
             response.body()?.sampleList?.let {
                it.map {
                    CarsModel(it.id, it.modelCar, it.imageCar, it.engine, it.informationMachines,it.photo)
                }
            } ?: kotlin.run {
                emptyList()
        }
        }
    }
}





