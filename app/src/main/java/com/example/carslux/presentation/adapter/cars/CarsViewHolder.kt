package com.example.carslux.presentation.adapter.cars

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.CarsModelBinding
import com.example.carslux.domain.model.CarsModel
import com.squareup.picasso.Picasso

class CarsViewHolder(
    private val binding: CarsModelBinding,
    private val carsListener: CarsListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(carsModel: CarsModel) {
        binding.name.text = carsModel.modelCar
        Picasso.get().load(Uri.parse(carsModel.imageCar)).into(binding.carImage)

        binding.carImage.setOnClickListener {
            carsListener.onClick()
            carsModel.modelCar
            carsModel.imageCar
            carsModel.engine
            carsModel.informationMachines
            carsModel.photo
        }

        itemView.setOnClickListener {
            carsListener.onElementSelect(
                carsModel.id,
                carsModel.modelCar,
                carsModel.imageCar,
                carsModel.engine,
                carsModel.informationMachines,
                carsModel.photo
            )
        }

        binding.carDelete.setOnClickListener {
            carsListener.onDeleteCar(carsModel.id)
        }

        binding.carFav.setOnClickListener {
            carsListener.onFavClick(carsModel.id)
        }
    }
}

