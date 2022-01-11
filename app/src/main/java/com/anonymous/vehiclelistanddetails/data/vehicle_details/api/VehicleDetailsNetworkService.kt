package com.anonymous.vehiclelistanddetails.data.vehicle_details.api

import com.anonymous.vehiclelistanddetails.data.vehicle_details.model.VehicleDetailsRemote
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface VehicleDetailsNetworkService {
    @GET("vehicles/{id}")
    suspend fun getVehicles(@Path("id")id:String):ApiResponse<VehicleDetailsRemote>

}
