package com.example.carslux.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.carslux.data.database.CarsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@Dao
interface CarsDao {

    @Insert
    fun insertCarsEntity(carsEntity: CarsEntity)

    @Query("SELECT * FROM CarsEntity")
    fun getCarsEntities(): Flow<List<CarsEntity>>

    @Query("SELECT(SELECT COUNT(*) FROM CarsEntity) !=0")
    fun doesCarsEntityExist(): Flow<Boolean>

    @Query("DELETE FROM CarsEntity WHERE id =:id")
    fun deleteCarEntityById(id: Int)

    @Query("SELECT * FROM CarsEntity WHERE id =:id ")
    fun findItemEntityById(id: Int): CarsEntity

    @Insert(onConflict = IGNORE)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity ")
    fun getFavoritesEntities(): Flow<List<FavoritesEntity>>

    @Query("DELETE FROM FavoritesEntity WHERE id =:id")
    fun deleteFavoritesEntityId(id: Int)


}