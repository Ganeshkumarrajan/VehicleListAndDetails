package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCase
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCaseImpl
import org.koin.dsl.module

val UseCaseModule = module(override = true) {
    single {
        provideMovieListUseCase(get())
    }

}

fun provideMovieListUseCase(movieListRepository: VehicleRepository): VehicleUseCase {
    return VehicleUseCaseImpl(movieListRepository)
}
