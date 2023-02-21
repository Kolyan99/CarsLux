package com.example.carslux.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.R
import com.example.carslux.databinding.FragmentCarsBinding
import com.example.carslux.presentation.adapter.CarsAdapter
import com.example.carslux.presentation.adapter.CarsListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarsFragment : Fragment(), CarsListener {

   private val viewModel: CarsViewModel by viewModels()

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

        viewModel.getCars()

        viewModel.cars.observe(viewLifecycleOwner){ listCar ->
            carsAdapter.submitList(listCar)
        }

        viewModel.msg.observe(viewLifecycleOwner){ msg->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick() {
       viewModel.imageViewClicked()
    }

    override fun onElementSelect(name: Int, model: String, image: String) {
    val informationFragment = InformationFragment()
        val bundel = Bundle()
        bundel.putString("name", name.toString())
        bundel.putString("model", model)
        bundel.putString("image", image)
        informationFragment.arguments = bundel
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, InformationFragment())
            .commit()



    }
}