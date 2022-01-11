package com.anonymous.vehiclelistanddetails.domain.vehicle_details.use_case

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.repo.VehicleDetailsRepository
import kotlinx.coroutines.flow.Flow

class VehicleDetailsUseCaseImpl(private val vehicleDetailsRepository: VehicleDetailsRepository):VehicleDetailsUseCase {
    override suspend fun vehicleDetails(id: String): Flow<RemoteDateResponse<VehicleDetailsDomain>?> =
        vehicleDetailsRepository.vehicleDetails(id)
}
