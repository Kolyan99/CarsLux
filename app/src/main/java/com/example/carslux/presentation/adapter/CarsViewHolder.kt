package com.example.carslux.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.CarsModelBinding
import com.example.carslux.domain.model.CarsModel

class CarsViewHolder(
    private val binding: CarsModelBinding,
    private val carsListener: CarsListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(carsModel: CarsModel) {
        binding.image.setBackgroundResource(carsModel.image)
        binding.name.setText(carsModel.name)



        itemView.setOnClickListener {
            carsListener.onElementSelect(
                carsModel.image,
                carsModel.name,
                carsModel.model,
            )
        }
    }
}

