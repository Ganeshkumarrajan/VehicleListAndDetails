package com.anonymous.vehiclelistanddetails.domain.vehicle.use_case

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow

class VehicleUseCaseImpl(private val vehicleRepository: VehicleRepository) : VehicleUseCase {
    override suspend fun vehicles(): Flow<RemoteDateResponse<List<VehicleDomain>>?> =
        vehicleRepository.vehicles()
}
