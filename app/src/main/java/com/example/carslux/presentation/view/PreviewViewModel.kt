package com.example.carslux.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carslux.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PreviewViewModel @Inject constructor(

) : ViewModel() {

    private val _nav = MutableLiveData<NavToCars>()
    val nav: LiveData<NavToCars?> = _nav

    fun previewButtonClick() {
        _nav.value = NavToCars(
            R.id.action_previewFragment_to_carsFragment2,
            R.id.previewFragment
        )
    }
}


data class NavToCars(
    val destinationId: Int,
    val removeFragment: Int
)