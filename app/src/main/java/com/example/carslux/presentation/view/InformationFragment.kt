package com.example.carslux.presentation.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.carslux.R
import com.example.carslux.Utils.Constants
import com.example.carslux.Utils.Constants.ENGINE
import com.example.carslux.Utils.Constants.IMAGECAR
import com.example.carslux.Utils.Constants.MODELCAR
import com.example.carslux.databinding.FragmentInformationBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InformationFragment : Fragment() {

    private val viewModel : InformationViewModel by viewModels()

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

        binding.infoName.findViewById<TextView>(R.id.info_name)
        binding.infoImage.findViewById<ImageView>(R.id.info_image)
        binding.infoModel.findViewById<TextView>(R.id.info_model)

        val bundle = arguments
        bundle?.let { safebundel ->
            val modelcar = safebundel.getString(MODELCAR)
            val image = safebundel.getString(IMAGECAR)
            val model = safebundel.getString(ENGINE)




            binding.infoName.text = modelcar
            binding.infoModel.text = model
            Picasso.get().load(Uri.parse(image)).into(binding.infoImage)





        }
    }
}