package com.example.carslux.presentation

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.carslux.R
import com.example.carslux.databinding.ActivityMainBinding
import com.example.carslux.presentation.view.CarsFragment
import com.example.carslux.presentation.view.FavoritesFragment
import com.example.carslux.presentation.view.PreviewFragment
import com.example.carslux.utils.NetworkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        val inflater = findViewById<View>(R.id.tvNetworkError)
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this){
            if (it){
                Toast.makeText(this, getString(R.string.Connect_internet), Toast.LENGTH_SHORT).show()
                inflater.visibility = View.GONE
            }else{
                Toast.makeText(this,getString(R.string.Disconnect), Toast.LENGTH_SHORT).show()
                inflater.visibility = View.VISIBLE
            }
        }


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController


        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, nav, _ ->
            if (nav.id == R.id.previewFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }
}

