package com.example.carslux.data.repository

import com.example.carslux.data.database.CarsEntity
import com.example.carslux.data.database.dao.CarsDao
import com.example.carslux.data.database.dao.FavoritesEntity
import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel
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

    override suspend fun findItemEntityById(id: Int): CarsModel {
      return  withContext(Dispatchers.IO){
            val carsEntity = carsDao.findItemEntityById(id)
            CarsModel(
                carsEntity.id,
                carsEntity.modelCar,
                carsEntity.imageCar,
                carsEntity.engine,
                carsEntity.informationMachines,
                carsEntity.photo
            )
        }
    }

    override suspend fun favClick(carsModel: CarsModel) {
        withContext(Dispatchers.IO){
            carsDao.insertFavoritesEntity(
                FavoritesEntity(carsModel.id,
                carsModel.modelCar,
                carsModel.imageCar,
                carsModel.engine,
                carsModel.informationMachines,
                carsModel.photo)
            )
        }
    }

    override suspend fun getFavorites(): List<FavoriteModel> {
       return withContext(Dispatchers.IO){
            val favoriteEntity = carsDao.getFavoritesEntities()
            favoriteEntity.map {
                FavoriteModel(
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

    override suspend fun deleteFavorite(id: Int) {
        withContext(Dispatchers.IO){
            carsDao.deleteFavoritesEntityId(id)
        }
    }
}





