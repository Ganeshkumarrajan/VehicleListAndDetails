package com.anonymous.vehiclelistanddetails.data.vehicle_details.mapper

import com.anonymous.vehiclelistanddetails.data.util.APIResponseMap
import com.anonymous.vehiclelistanddetails.data.vehicle_details.model.VehicleDetailsRemote
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain

class VehicleDetailsMap : APIResponseMap<VehicleDetailsRemote, VehicleDetailsDomain> {
    override fun toDomain(In: VehicleDetailsRemote): VehicleDetailsDomain =
        VehicleDetailsDomain(
            In.id ?: "",
            In.make ?: "",
            In.model ?: "",
            In.modelYear ?: 0,
            In.displayVariant ?: "",
            In.mileage ?: 0,
            In.registrationYear ?: 0,
            In.images?.main?.url ?: ""
        )
}
