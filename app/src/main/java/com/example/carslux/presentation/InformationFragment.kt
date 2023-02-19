package com.example.carslux.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.carslux.R
import com.example.carslux.databinding.FragmentInformationBinding
import com.example.carslux.databinding.FragmentPreviewBinding


class InformationFragment : Fragment() {

    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformationBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundel = arguments
        bundel?.let { safebundel ->

            val image = safebundel.getString("image")
            val name = safebundel.getInt("name")
            val model = safebundel.getString("model")

            binding.infoName.text = name.toString()
            binding.infoImage.drawable


        }
    }
}