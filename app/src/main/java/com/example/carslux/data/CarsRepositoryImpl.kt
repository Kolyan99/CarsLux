package com.example.carslux.data

import com.example.carslux.R
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(): CarsRepository {

    override fun getCar(): List<CarsModel> {
        val listCars = listOf<CarsModel>(
            CarsModel(
                R.drawable.ic_launcher_background,
                "Mersedes",
                "E63 AMG"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Mazda",
                "626"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Toyota",
                "Camry"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Nissan",
                "Almera"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Opel",
                "Astra"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "BMV",
                "540I"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Audi",
                "Rs5"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"
            ),
            CarsModel(
                R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"
            )
        )
        return (listCars)
    }
}