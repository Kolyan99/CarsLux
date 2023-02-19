package com.example.carslux.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.CarsModelBinding
import com.example.carslux.domain.model.CarsModel

class CarsViewHolder(
    private val binding: CarsModelBinding,
    private val carsListener: CarsListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(CarsModel: CarsModel) {
        binding.image.text = CarsModel.image.toString()
        binding.name.text = CarsModel.name


        itemView.setOnClickListener {
            carsListener.onElementSelect(
                CarsModel.image,
                CarsModel.name,
                CarsModel.model,
            )
        }
    }
}

