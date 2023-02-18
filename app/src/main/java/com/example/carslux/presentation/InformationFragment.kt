package com.example.carslux.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.carslux.R


class InformationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoImage = view.findViewById<ImageView>(R.id.image)
        val infoName = view.findViewById<TextView>(R.id.name)
        val infoModel = view.findViewById<TextView>(R.id.model)

        val bundel = arguments
        bundel?.let { safebundel ->

            val image = safebundel.getString("image")
            val name = safebundel.getString("name")
            val model = safebundel.getString("model")

            //infoImage.setBackgroundResource(image)
            infoName.text = name
            infoModel.text = model

        }
    }
}