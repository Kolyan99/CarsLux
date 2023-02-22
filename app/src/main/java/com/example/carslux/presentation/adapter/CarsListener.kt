package com.example.carslux.presentation.adapter

interface CarsListener {

    fun onClick()

    fun onElementSelect(id: Int, modelCar: String, imageCar: String, engine: String)
}