package com.example.carslux.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.R
import com.example.carslux.domain.model.CarsModel

class CarsViewHolder(
    private val view: View,
    private val carsListener: CarsListener
) : RecyclerView.ViewHolder(view) {


    fun bind(CarsModel: CarsModel) {
        val image: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
        val model: TextView = view.findViewById(R.id.model)


        image.setBackgroundResource(CarsModel.image)
        name.text = CarsModel.name
        model.text = CarsModel.model


        image.setOnClickListener {
            carsListener.onClick()
        }

        itemView.setOnClickListener {
            carsListener.onElementSelect(
                CarsModel.image,
                CarsModel.name,
                CarsModel.model,
            )
        }
    }
}
