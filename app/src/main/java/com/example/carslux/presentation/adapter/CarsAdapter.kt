package com.example.carslux.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.R
import com.example.carslux.domain.model.CarsModel

class CarsAdapter(
    private val carsListener: CarsListener
): RecyclerView.Adapter<CarsViewHolder>() {

    private var listCars = mutableListOf<CarsModel>()

   fun submitList(list: List<CarsModel>){
       this.listCars = list.toMutableList()
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_model,parent,false)
        return CarsViewHolder(view, carsListener)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(listCars[position])
    }

    override fun getItemCount(): Int {
        return listCars.size
    }
}