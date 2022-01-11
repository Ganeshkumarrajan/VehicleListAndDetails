package com.anonymous.vehiclelistanddetails.data.vehicle_details.repo

import com.anonymous.vehiclelistanddetails.data.util.convertAPIResponse
import com.anonymous.vehiclelistanddetails.data.vehicle_details.mapper.VehicleDetailsMap
import com.anonymous.vehiclelistanddetails.data.vehicle_details.api.VehicleDetailsNetworkService
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.repo.VehicleDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehicleDetailsRepositoryImpl(private val api: VehicleDetailsNetworkService) : VehicleDetailsRepository {
    override suspend fun vehicleDetails(id: String): Flow<RemoteDateResponse<VehicleDetailsDomain>?> =
        flow {
            emit(
                convertAPIResponse(
                    api.getVehicles(id), VehicleDetailsMap()
                )
            )
        }
}
