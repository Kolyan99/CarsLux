package com.example.carslux.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavHelper {

    fun Fragment.navigateWithBundle(destination: Int, bundel: Bundle){
        findNavController().navigate(destination,bundel)
    }

    fun Fragment.navigateWithDeleteBackStack(destination: Int, fragmentToRemove: Int){
        val navOption = NavOptions.Builder()
        navOption.setPopUpTo(fragmentToRemove, true)
        findNavController().navigate(
            destination,
            null,
            navOption.build()
        )
    }
}