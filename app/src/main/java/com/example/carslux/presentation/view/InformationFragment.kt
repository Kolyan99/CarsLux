package com.example.carslux.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.carslux.databinding.FragmentInformationBinding
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