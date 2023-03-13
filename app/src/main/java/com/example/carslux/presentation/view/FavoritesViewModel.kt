package com.example.carslux.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carslux.R
import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.model.CarsModel
import com.example.carslux.domain.model.FavoriteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor
) : ViewModel() {

    val showFavorite = flow<Flow<List<FavoriteModel>>>{ emit(carsInteractor.getFavorites())}

    private val _favorites = MutableLiveData<List<FavoriteModel>>()
    val favorites = _favorites

    private val _bundel = MutableLiveData<NavigateFavorites?>()
    val bundel: LiveData<NavigateFavorites?> = _bundel



    fun elementSelectFav(
        id: Int,
        modelCar: String,
        imageCar: String,
        engine: String,
        informationMachines: String,
        photo: String
    ) {
        _bundel.value = NavigateFavorites(
            id,
            modelCar,
            imageCar,
            engine,
            informationMachines,
            photo,
            R.id.action_favoritesFragment_to_informationFragment
        )
    }

    fun userNavigated() {
        _bundel.value = null
    }

    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            carsInteractor.deleteFavorite(id)
        }
    }
}

data class NavigateFavorites(
    val id: Int,
    val modelCar: String,
    val imageCar: String,
    val enegine: String,
    val informationMachines: String,
    val photo: String,
    val destinationId: Int
)