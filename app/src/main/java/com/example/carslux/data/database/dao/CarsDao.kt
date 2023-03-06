package com.example.carslux.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.carslux.data.database.CarsEntity
import javax.inject.Inject


@Dao
interface CarsDao {

    @Insert
    fun insertCarsEntity(carsEntity: CarsEntity)

    @Query("SELECT * FROM CarsEntity")
    fun getCarsEntities(): List<CarsEntity>

    @Query("SELECT(SELECT COUNT(*) FROM CarsEntity) !=0")
    fun doesCarsEntityExist(): Boolean

    @Query("DELETE FROM CarsEntity WHERE id =:id")
    fun deleteCarEntityById(id: Int)

    @Query("SELECT * FROM CarsEntity WHERE id =:id ")
    fun findItemEntityById(id: Int): CarsEntity

    @Insert(onConflict = IGNORE) // ignore when conflict occurs (ignore items if same)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity ")
    fun getFavoritesEntities(): List<FavoritesEntity>

}