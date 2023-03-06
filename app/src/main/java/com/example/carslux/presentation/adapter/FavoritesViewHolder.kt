package com.example.carslux.presentation.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.FavoriteModelBinding
import com.example.carslux.domain.model.FavoriteModel
import com.squareup.picasso.Picasso

class FavoritesViewHolder(
    private val binding: FavoriteModelBinding,
    private val favoritesListener: FavoritesListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(carsModel: FavoriteModel) {
        binding.favName.text = carsModel.modelCar
        Picasso.get().load(Uri.parse(carsModel.imageCar)).into(binding.favImage)




    }
}

