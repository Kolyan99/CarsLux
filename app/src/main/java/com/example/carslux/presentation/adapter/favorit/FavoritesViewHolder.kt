package com.example.carslux.presentation.adapter.favorit

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.FavoriteModelBinding
import com.example.carslux.domain.model.FavoriteModel
import com.squareup.picasso.Picasso

class FavoritesViewHolder(
    private val binding: FavoriteModelBinding,
    private val favoritesListener: FavoritesListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(favorite: FavoriteModel) {
        binding.favNameFav.text = favorite.modelCar
        Picasso.get().load(Uri.parse(favorite.imageCar)).into(binding.favImageFav)

        binding.favDeleteFav.setOnClickListener {
            favoritesListener.onDeleteFavorite(favorite.id)
        }

        itemView.setOnClickListener {
            favoritesListener.onElementSelect(
                favorite.id,
                favorite.modelCar,
                favorite.imageCar,
                favorite.engine,
                favorite.informationMachines,
                favorite.photo
            )
        }
    }

}

