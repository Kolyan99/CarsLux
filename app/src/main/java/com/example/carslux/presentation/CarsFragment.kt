package com.example.carslux.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.R
import com.example.carslux.databinding.FragmentCarsBinding
import com.example.carslux.domain.model.CarsModel
import com.example.carslux.presentation.adapter.CarsAdapter
import com.example.carslux.presentation.adapter.CarsListener


class CarsFragment : Fragment(), CarsListener {

    private lateinit var carsAdapter: CarsAdapter

    private var _binding: FragmentCarsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentCarsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carsAdapter = CarsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = carsAdapter


        val listCars = listOf<CarsModel>(
            CarsModel(R.drawable.ic_launcher_background,
            "Mersedes",
            "E63 AMG"),
            CarsModel(R.drawable.ic_launcher_foreground,
            "Mersedes",
            "E220"),
            CarsModel(R.drawable.ic_launcher_foreground,
            "Mersedes",
            "CLS 550"),
            CarsModel(R.drawable.ic_launcher_foreground,
            "Mersedes",
            "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
            CarsModel(R.drawable.ic_launcher_foreground,
                "Mersedes",
                "S550 4Matic"),
        )
        carsAdapter.submitList(listCars)
    }

    override fun onClick() {
        Toast.makeText(context, "Image cliked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelect(name: Int, model: String, image: String) {
    val informationFragment = InformationFragment()
        val bundel = Bundle()
        bundel.putInt("name", name)
        bundel.putString("model", model)
        bundel.putString("image", image)
        informationFragment.arguments = bundel
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, InformationFragment())
            .commit()



    }
}