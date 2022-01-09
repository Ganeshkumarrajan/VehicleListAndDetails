package com.anonymous.vehiclelistanddetails.data.vehicle.model

data class VehicleRemote(
    val id: String?,
    val make: String?,
    val model: String?,
    val modelYear: String?,
    val displayVariant: String?
)

data class VehicleRemoteResult(val results: List<VehicleRemote>)
