package com.example.carslux.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.carslux.R
import com.example.carslux.databinding.FragmentPreviewBinding
import java.util.function.Predicate


class PreviewFragment : Fragment() {

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

        val textView = view.findViewById<TextView>(R.id.text_prev)
        val textView2 = view.findViewById<TextView>(R.id.text_prev2)

        binding.btnPrev.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, CarsFragment())
                .commit()
        }

    }


}