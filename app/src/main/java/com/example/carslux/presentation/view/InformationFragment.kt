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
import com.example.carslux.utils.Constants
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
        binding.informationmachince.findViewById<TextView>(R.id.informationmachince)
        binding.infoPhoto.findViewById<ImageView>(R.id.info_photo)

        val bundle = arguments
        bundle?.let { safebundel ->
            val modelcar = safebundel.getString(Constants.MODELCAR)
            val image = safebundel.getString(Constants.IMAGECAR)
            val model = safebundel.getString(Constants.ENGINE)
            val infomachince = safebundel.getString(Constants.INFORMATIONMACHINES)
            val photo = safebundel.getString(Constants.PHOTO)


            binding.infoName.text = modelcar
            binding.infoModel.text = model
            Picasso.get().load(Uri.parse(image)).into(binding.infoImage)
            binding.informationmachince.text = infomachince
            Picasso.get().load(Uri.parse(photo)).into(binding.infoPhoto)





        }
    }
}