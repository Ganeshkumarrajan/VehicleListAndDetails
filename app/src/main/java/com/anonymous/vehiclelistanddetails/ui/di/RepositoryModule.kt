package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.data.vehicle.repo.VehicleRepositoryImpl
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<VehicleRepository> {
        VehicleRepositoryImpl(get())
    }

}