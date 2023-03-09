package com.example.carslux.data.repository

import android.util.Log
import com.example.carslux.data.database.CarsEntity
import com.example.carslux.data.database.dao.CarsDao
import com.example.carslux.data.database.dao.FavoritesEntity
import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val carsDao: CarsDao,
    private val apiService: ApiService
) : CarsRepository {

    override suspend fun getCar() {
        return withContext(Dispatchers.IO) {
            carsDao.doesCarsEntityExist().collect {
                if (!it) {
                    val response = apiService.getCar()
                    Log.w("get", response.body()?.sampleList.toString())
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
    }

    override suspend fun showCar(): Flow<List<CarsModel>> {
        return withContext(Dispatchers.IO) {
            val carsEntity = carsDao.getCarsEntities()
            carsEntity.map { carsList ->
                carsList.map { car->
                    CarsModel(
                        car.id,
                        car.modelCar,
                        car.imageCar,
                        car.engine,
                        car.informationMachines,
                        car.photo
                    )
                }
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

    override suspend fun getFavorites(): Flow<List<FavoriteModel>> {
       return withContext(Dispatchers.IO){
            val favoriteEntity = carsDao.getFavoritesEntities()
            favoriteEntity.map { favoriteList ->
                favoriteList.map { favorit ->
                    FavoriteModel(
                        favorit.id,
                        favorit.modelCar,
                        favorit.imageCar,
                        favorit.engine,
                        favorit.informationMachines,
                        favorit.photo
                    )
                }
            }
       }
    }


    override suspend fun deleteFavorite(id: Int) {
        withContext(Dispatchers.IO){
            carsDao.deleteFavoritesEntityId(id)
        }
    }
}





