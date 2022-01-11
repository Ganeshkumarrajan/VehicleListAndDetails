package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.data.vehicle.repo.VehicleRepositoryImpl
import com.anonymous.vehiclelistanddetails.data.vehicle_details.repo.VehicleDetailsRepositoryImpl
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.repo.VehicleDetailsRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<VehicleRepository> {
        VehicleRepositoryImpl(get())
    }

    single<VehicleDetailsRepository> {
        VehicleDetailsRepositoryImpl(get())
    }

}