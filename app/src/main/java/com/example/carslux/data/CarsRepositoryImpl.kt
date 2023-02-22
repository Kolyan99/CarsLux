package com.example.carslux.data

import com.example.carslux.data.service.ApiService
import com.example.carslux.domain.CarsRepository
import com.example.carslux.domain.model.CarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CarsRepository {

    override suspend fun getCar(): List<CarsModel> {
      return withContext(Dispatchers.IO){
            val response = apiService.getCar()
             response.body()?.sampleList?.let {
                it.map {
                    CarsModel(it.id, it.modelCar, it.imageCar, it.engine)
                }
            } ?: kotlin.run {
                emptyList()
        }
        }
    }
}





//        val listCars = listOf<CarsModel>(
//            CarsModel(
//                R.drawable.ic_launcher_background,
//                "Mersedes",
//                "E63 AMG"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Mazda",
//                "626"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Toyota",
//                "Camry"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Nissan",
//                "Almera"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Opel",
//                "Astra"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "BMV",
//                "540I"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Audi",
//                "Rs5"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Mersedes",
//                "S550 4Matic"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Mersedes",
//                "S550 4Matic"
//            ),
//            CarsModel(
//                R.drawable.ic_launcher_foreground,
//                "Mersedes",
//                "S550 4Matic"
//            )
//        )
//        return (listCars)

