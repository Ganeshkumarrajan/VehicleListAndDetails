package com.anonymous.vehiclelistanddetails.data.vehicle.repo

import com.anonymous.vehiclelistanddetails.data.util.convertAPIResponse
import com.anonymous.vehiclelistanddetails.data.vehicle.api.VehicleNetworkService
import com.anonymous.vehiclelistanddetails.data.vehicle.mapper.VehiclesMap
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehicleRepositoryImpl(private val api: VehicleNetworkService) : VehicleRepository {
    override suspend fun vehicles(): Flow<RemoteDateResponse<List<VehicleDomain>>?>  = flow {
       emit(convertAPIResponse(
            api.getVehicles(), VehiclesMap()
        ))
    }
}
