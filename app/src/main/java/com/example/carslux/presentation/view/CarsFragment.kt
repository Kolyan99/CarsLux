package com.example.carslux.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carslux.R
import com.example.carslux.utils.Constants.ENGINE
import com.example.carslux.utils.Constants.IMAGECAR
import com.example.carslux.utils.Constants.MODELCAR
import com.example.carslux.databinding.FragmentCarsBinding
import com.example.carslux.presentation.adapter.cars.CarsAdapter
import com.example.carslux.presentation.adapter.cars.CarsListener
import com.example.carslux.utils.Constants.INFORMATIONMACHINES
import com.example.carslux.utils.Constants.PHOTO
import com.example.carslux.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

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


        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getCars.collect()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.showCars.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    carsAdapter.submitList(list)
                }
            }
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundel.observe(viewLifecycleOwner) { navBundel ->
            if (navBundel != null) {
                val bundle = Bundle()
                bundle.putString(MODELCAR, navBundel.modelCar)
                bundle.putString(IMAGECAR, navBundel.imageCar)
                bundle.putString(ENGINE, navBundel.enegine)
                bundle.putString(INFORMATIONMACHINES, navBundel.informationMachines)
                bundle.putString(PHOTO, navBundel.photo)
                navigateWithBundle(
                    navBundel.destinationId,
                    bundle
                )
                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelect(
        id: Int,
        modelCar: String,
        imageCar: String,
        engine: String,
        informationMachines: String,
        photo: String
    ) {
        viewModel.elementSelect(id, modelCar, imageCar, engine, informationMachines, photo)
    }

    override fun onDeleteCar(id: Int) {
        viewModel.deleteCar(id)
    }

    override fun onFavClick(id: Int) {
        viewModel.onFavClick(id)
    }
}





