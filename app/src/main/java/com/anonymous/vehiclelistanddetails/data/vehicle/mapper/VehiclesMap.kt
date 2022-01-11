package com.anonymous.vehiclelistanddetails.data.vehicle.mapper
import com.anonymous.vehiclelistanddetails.data.util.APIResponseMap
import com.anonymous.vehiclelistanddetails.data.vehicle.model.VehicleRemoteResult
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain

class VehiclesMap : APIResponseMap<VehicleRemoteResult, List<VehicleDomain>> {
    override fun toDomain(In: VehicleRemoteResult): List<VehicleDomain> =
        In.results.map {
            VehicleDomain(
                it.id ?: "",
                it.displayVariant ?: "",
                it.model ?: "",
                it.make ?: "",
                it.images?.main?.url ?: ""
            )
        }
}