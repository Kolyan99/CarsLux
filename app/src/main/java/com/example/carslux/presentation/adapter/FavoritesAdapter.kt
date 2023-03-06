package com.example.carslux.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.FavoriteModelBinding
import com.example.carslux.domain.model.FavoriteModel

class FavoritesAdapter(
    private val favoritesListener: FavoritesListener
) : RecyclerView.Adapter<FavoritesViewHolder>() {

    private var listfavorite = mutableListOf<FavoriteModel>()

    fun submitList(list: List<FavoriteModel>){
        this.listfavorite.clear()
        this.listfavorite = list.toMutableList()
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding = FavoriteModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoritesViewHolder(binding, favoritesListener)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listfavorite[position])
    }

    override fun getItemCount(): Int {
        return listfavorite.size
    }


}

