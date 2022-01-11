package com.anonymous.vehiclelistanddetails.domain.vehicle_details.model

data class VehicleDetailsDomain(val id :String,
                                   val make: String,
                                   val model: String,
                                   val modelYear: Int,
                                   val displayVariant: String,
                                   val mileage: Long,
                                   val registrationYear:Int,
                                   val image:String )
