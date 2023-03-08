package com.example.carslux.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carslux.R
import com.example.carslux.databinding.FragmentPreviewBinding
import com.example.carslux.utils.NavHelper.navigateWithDeleteBackStack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreviewFragment : Fragment() {

    private val viewModel: PreviewViewModel by viewModels()

    private var _binding: FragmentPreviewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPreviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigateWithDeleteBackStack(
                    it.destinationId,
                    it.removeFragment
                )
            }

        }
        binding.btnPrev.setOnClickListener {
            viewModel.previewButtonClick()

        }
    }
}

