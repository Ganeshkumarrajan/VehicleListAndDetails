package com.anonymous.vehiclelistanddetails.ui.vehicleDetails

import android.content.Context
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain

data class VehicleDetailsUI(
    val id: String?,
    val make: String?,
    val model: String?,
    val modelYear: String?,
    val displayVariant: String?,
    val mileage: String?,
    val registrationYear: String?,
    val image: String?
)

fun VehicleDetailsDomain.toUI(context: Context): VehicleDetailsUI =
    VehicleDetailsUI(
        this.id, context.getString(R.string.make) + this.make,
        context.getString(R.string.model) + this.model,
        context.getString(R.string.model_year) + this.modelYear,
        context.getString(R.string.display) + this.displayVariant,
        context.getString(R.string.mileage) + this.mileage,
        context.getString(R.string.display) + this.make,
        this.image
    )
