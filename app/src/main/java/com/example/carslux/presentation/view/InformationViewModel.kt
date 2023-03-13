package com.example.carslux.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.model.CarsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InformationViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor
) : ViewModel() {

}