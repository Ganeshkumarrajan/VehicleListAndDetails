package com.anonymous.vehiclelistanddetails.domain.vehicle_details.repo

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain
import kotlinx.coroutines.flow.Flow

interface VehicleDetailsRepository {
    suspend fun vehicleDetails(id:String): Flow<RemoteDateResponse<VehicleDetailsDomain>?>
}
