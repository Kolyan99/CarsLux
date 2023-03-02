package com.example.carslux.data.repository

import com.example.carslux.data.database.CarsEntity
import com.example.carslux.data.database.dao.CarsDao
import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val carsDao: CarsDao,
    private val apiService: ApiService
) : CarsRepository {

    override suspend fun getCar() {
        return withContext(Dispatchers.IO) {

            if (!carsDao.doesCarsEntityExist()) {
                val response = apiService.getCar()
                response.body()?.sampleList?.let {
                    it.map {
                        val carsEntity = CarsEntity(
                            it.id,
                            it.modelCar,
                            it.imageCar,
                            it.engine,
                            it.informationMachines,
                            it.photo
                        )
                        carsDao.insertCarsEntity(carsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showCar(): List<CarsModel> {
        return withContext(Dispatchers.IO) {
            val carsEntity = carsDao.getCarsEntities()
            carsEntity.map {
                CarsModel(
                    it.id,
                    it.modelCar,
                    it.imageCar,
                    it.engine,
                    it.informationMachines,
                    it.photo
                )
            }
        }
    }

    override suspend fun deleteCar(id: Int) {
        withContext(Dispatchers.IO){
            carsDao.deleteCarEntityById(id)
        }
    }


}





