package com.example.carslux.data.model

import com.google.gson.annotations.SerializedName

data class CarsResponse(
    @SerializedName("sample")
    val sampleList: List<Sample>
)

data class Sample(
    @SerializedName("id")
    val id: Int,
    @SerializedName("modelCar")
    val modelCar: String,
    @SerializedName("imageCar")
    val imageCar: String,
    @SerializedName("engine")
    val engine: String,
    @SerializedName("informationMachines")
    val informationMachines: String,
    @SerializedName("photo")
    val photo: String
    )
