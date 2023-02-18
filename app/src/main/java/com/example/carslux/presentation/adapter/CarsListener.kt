package com.example.carslux.presentation.adapter

interface CarsListener {

    fun onClick()

    fun onElementSelect(name: Int, model: String, image: String)
}