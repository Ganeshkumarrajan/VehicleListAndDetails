package com.anonymous.vehiclelistanddetails.vehicle

import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCaseImpl
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class VehiclesUseCaseShould {

    @Mock
    private lateinit var vehicleRepository: VehicleRepository

    private lateinit var vehiclesUseCase: VehicleUseCaseImpl

    @Before
    fun init() {
        vehiclesUseCase = VehicleUseCaseImpl(vehicleRepository)
    }

    @Test
    fun getVehicles() = runBlocking {
        vehiclesUseCase.vehicles()
        verify(vehicleRepository).vehicles()
    }


}