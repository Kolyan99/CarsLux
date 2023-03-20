package com.example.carslux.presentation.adapter.cars

interface CarsListener {

    fun onClick()

    fun onElementSelect(id: Int, modelCar: String, imageCar: String, engine: String, informationMachines: String, photo: String)

    fun onDeleteCar(id: Int)

    fun onFavClick(id: Int, isFavorite: Boolean)
}