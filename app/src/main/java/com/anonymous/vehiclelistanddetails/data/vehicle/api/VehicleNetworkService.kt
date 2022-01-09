package com.anonymous.vehiclelistanddetails.data.vehicle.api

import com.anonymous.vehiclelistanddetails.data.vehicle.model.VehicleRemoteResult
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface VehicleNetworkService {
    @GET("search")
    suspend fun getVehicles():ApiResponse<VehicleRemoteResult>

}
