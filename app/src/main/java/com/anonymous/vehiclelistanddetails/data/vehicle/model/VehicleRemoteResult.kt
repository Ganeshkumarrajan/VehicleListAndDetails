package com.anonymous.vehiclelistanddetails.data.vehicle.model

data class VehicleRemote(
    val id: String?,
    val make: String?,
    val model: String?,
    val images: ImageMain?,
    val displayVariant: String?
)

data class Image(val url:String?)
data class ImageMain(val main:Image?)
data class VehicleRemoteResult(val results: List<VehicleRemote>)
