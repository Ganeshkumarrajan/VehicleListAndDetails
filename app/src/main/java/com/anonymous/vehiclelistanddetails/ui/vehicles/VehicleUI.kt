package com.anonymous.vehiclelistanddetails.ui.vehicles

import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain

data class VehicleUI(
    val id: String,
    val displayVariant: String,
    val model: String,
    val manufacture: String,
    val imageURL: String
)

fun VehicleDomain.toUI():VehicleUI =
    VehicleUI(this.id,this.displayVariant,this.model,this.manufacture,this.imageURL)
