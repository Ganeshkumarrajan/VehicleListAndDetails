package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCase
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCaseImpl
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.repo.VehicleDetailsRepository
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.use_case.VehicleDetailsUseCase
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.use_case.VehicleDetailsUseCaseImpl
import org.koin.dsl.module

val UseCaseModule = module(override = true) {
    single {
        provideVehiclesUseCase(get())
    }

    single {
        provideVehicleDetailsUseCase(get())
    }

}

fun provideVehiclesUseCase(movieListRepository: VehicleRepository): VehicleUseCase {
    return VehicleUseCaseImpl(movieListRepository)
}

fun provideVehicleDetailsUseCase(movieListRepository: VehicleDetailsRepository): VehicleDetailsUseCase {
    return VehicleDetailsUseCaseImpl(movieListRepository)
}

