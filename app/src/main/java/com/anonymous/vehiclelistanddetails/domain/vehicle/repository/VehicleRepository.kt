package com.anonymous.vehiclelistanddetails.domain.vehicle.repository

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import kotlinx.coroutines.flow.*

interface VehicleRepository {
    suspend fun vehicles():Flow<RemoteDateResponse<List<VehicleDomain>>?>
}
