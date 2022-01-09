package com.anonymous.vehiclelistanddetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehiclesViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<VehiclesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.vehiclesLiveData.observeForever {
            print(it)
        }

        viewModel.getVehicles()
    }
}