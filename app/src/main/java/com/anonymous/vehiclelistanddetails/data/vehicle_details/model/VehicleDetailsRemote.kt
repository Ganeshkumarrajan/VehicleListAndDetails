package com.anonymous.vehiclelistanddetails.data.vehicle_details.model

import com.anonymous.vehiclelistanddetails.data.vehicle.model.ImageMain

data class VehicleDetailsRemote (
    val id :String?,
    val make: String?,
    val model: String?,
    val modelYear: Int?,
    val displayVariant: String?,
    val mileage: Long?,
    val registrationYear:Int?,
    val images: ImageMain?,
)

data class Image(val url:String?)
data class ImageMain(val main:Image?)