package com.example.carslux.data.database.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoritesEntity")
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "modelCar")
    val modelCar: String,
    @ColumnInfo(name = "imageCar")
    val imageCar: String,
    @ColumnInfo(name = "engine")
    val engine: String,
    @ColumnInfo(name = "informationMachines")
    val informationMachines: String,
    @ColumnInfo(name = "photo")
    val photo: String
)
