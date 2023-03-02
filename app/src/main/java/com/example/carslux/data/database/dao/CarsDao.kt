package com.example.carslux.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
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

}