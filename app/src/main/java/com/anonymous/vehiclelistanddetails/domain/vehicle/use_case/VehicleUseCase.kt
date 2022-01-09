package com.anonymous.vehiclelistanddetails.domain.vehicle.use_case

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import kotlinx.coroutines.flow.Flow

interface VehicleUseCase {
      suspend fun vehicles(): Flow<RemoteDateResponse<List<VehicleDomain>>?>
}
