package com.example.carslux.presentation.view

import android.provider.Settings.System.getString
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carslux.R
import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.model.CarsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor
) : ViewModel() {

    val showCars = flow<Flow<List<CarsModel>>>{emit(carsInteractor.showCars())}
    val getCars = flow {emit(carsInteractor.getCars())  }

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundel = MutableLiveData<NavigateParametrs?>()
    val bundel: LiveData<NavigateParametrs?> = _bundel


    fun imageViewClicked() {
        _msg.value = R.string.Click_on_picture
    }


    fun elementSelect(
        id: Int,
        modelCar: String,
        imageCar: String,
        engine: String,
        informationMachines: String,
        photo: String
    ) {
        _bundel.value = NavigateParametrs(
            id,
            modelCar,
            imageCar,
            engine,
            informationMachines,
            photo,
            R.id.action_carsFragment2_to_informationFragment
        )
    }

    fun userNavigated() {
        _bundel.value = null
    }

    fun deleteCar(id: Int) {
        viewModelScope.launch {
            carsInteractor.deleteCar(id)
        }
    }

    fun onFavClick(id: Int) {
        viewModelScope.launch {
            carsInteractor.onFavClick(id)
        }
    }
}

data class NavigateParametrs(
    val id: Int,
    val modelCar: String,
    val imageCar: String,
    val enegine: String,
    val informationMachines: String,
    val photo: String,
    val destinationId: Int
)