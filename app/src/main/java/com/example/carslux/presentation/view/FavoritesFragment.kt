package com.example.carslux.presentation.view

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carslux.R
import com.example.carslux.databinding.FragmentFavoritesBinding
import com.example.carslux.domain.model.FavoriteModel
import com.example.carslux.presentation.adapter.favorit.FavoritesAdapter
import com.example.carslux.presentation.adapter.favorit.FavoritesListener
import com.example.carslux.utils.Constants
import com.example.carslux.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

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

        if (context?.let { checkcontext(it) } == true){
            Toast.makeText(context, getString(R.string.internet_up), Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, getString(R.string.internet_down), Toast.LENGTH_LONG).show()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.showFavorite.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    favoritesAdapter.submitList(list)
                }
            }
        }


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

    private fun checkcontext(context: Context): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo !=null && networkInfo.isConnected
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