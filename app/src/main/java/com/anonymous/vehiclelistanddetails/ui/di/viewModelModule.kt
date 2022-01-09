package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.ui.vehicles.VehiclesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { VehiclesViewModel(get()) }
}
