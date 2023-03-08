package com.example.carslux.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carslux.databinding.FragmentFavoritesBinding
import com.example.carslux.presentation.adapter.favorit.FavoritesAdapter
import com.example.carslux.presentation.adapter.favorit.FavoritesListener
import com.example.carslux.utils.Constants
import com.example.carslux.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), FavoritesListener {

    private val viewModel: FavoritesViewModel by viewModels()

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesAdapter = FavoritesAdapter(this)
        binding.favRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.favRecyclerView.adapter = favoritesAdapter

        viewModel.getFavorites()

        viewModel.favorites.observe(viewLifecycleOwner){
            favoritesAdapter.submitList(it)
        }

        viewModel.bundel.observe(viewLifecycleOwner){ navBundel->
            if (navBundel != null) {
                val bundle = Bundle()
                bundle.putString(Constants.MODELCAR, navBundel.modelCar)
                bundle.putString(Constants.IMAGECAR, navBundel.imageCar)
                bundle.putString(Constants.ENGINE, navBundel.enegine)
                bundle.putString(Constants.INFORMATIONMACHINES, navBundel.informationMachines)
                bundle.putString(Constants.PHOTO, navBundel.photo)
                navigateWithBundle(navBundel.destinationId,
                    bundle)
                viewModel.userNavigated()
            }
        }

    }

    override fun onDeleteFavorite(id: Int) {
        viewModel.deleteFavorite(id)
    }

    override fun onElementSelect(
        id: Int,
        modelCar: String,
        imageCar: String,
        engine: String,
        informationMachines: String,
        photo: String
    ) {
        viewModel.elementSelectFav(id, modelCar, imageCar, engine, informationMachines, photo)
    }

}