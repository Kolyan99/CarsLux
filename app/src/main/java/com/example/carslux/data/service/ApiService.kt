package com.example.carslux.data.service

import com.example.carslux.data.model.CarsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/flQzfV")
    suspend fun getCar(): Response<CarsResponse>
}