package com.anonymous.vehiclelistanddetails.domain.vehicle_details.use_case

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain
import kotlinx.coroutines.flow.Flow

interface VehicleDetailsUseCase {
    suspend fun vehicleDetails(id:String): Flow<RemoteDateResponse<VehicleDetailsDomain>?>
}
