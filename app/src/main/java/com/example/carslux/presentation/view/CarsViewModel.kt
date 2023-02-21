package com.example.carslux.presentation.view

import android.provider.Settings.System.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carslux.R
import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.model.CarsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor
) : ViewModel() {

    private val _cars = MutableLiveData<List<CarsModel>>()
    val cars : LiveData<List<CarsModel>> = _cars

    private val _msg = MutableLiveData<Int>()
    val msg : LiveData<Int> = _msg


    fun getCars(){
        val listCars = carsInteractor.getCars()
        _cars.value = listCars
    }

    fun imageViewClicked() {
        _msg.value = R.string.image_click
    }
}