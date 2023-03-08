package com.example.carslux.presentation.adapter.favorit

interface FavoritesListener {

    fun onDeleteFavorite(id: Int)

    fun onElementSelect(id: Int, modelCar: String, imageCar: String, engine: String, informationMachines: String, photo: String)
}