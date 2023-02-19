package com.example.carslux.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.databinding.CarsModelBinding
import com.example.carslux.domain.model.CarsModel

class CarsAdapter(
    private val carsListener: CarsListener
): RecyclerView.Adapter<CarsViewHolder>() {

    private var listCars = mutableListOf<CarsModel>()

   fun submitList(list: List<CarsModel>){
       this.listCars.clear()
       this.listCars = list.toMutableList()
       this.notifyDataSetChanged()
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val binding = CarsModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarsViewHolder(binding, carsListener)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(listCars[position])
    }

    override fun getItemCount(): Int {
        return listCars.size
    }
}