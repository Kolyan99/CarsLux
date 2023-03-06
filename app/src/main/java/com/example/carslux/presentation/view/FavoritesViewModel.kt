package com.example.carslux.presentation.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carslux.domain.CarsInteractor
import com.example.carslux.domain.model.FavoriteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor
): ViewModel() {

    private val _favorites = MutableLiveData<List<FavoriteModel>>()
    val favorites = _favorites


    fun getFavorites(){
        viewModelScope.launch {
            try {
                val favorites = carsInteractor.getFavorites()
                _favorites.value = favorites
            }catch (e: Exception){
                Log.w("Fav error", e.toString())
            }
        }
    }
}