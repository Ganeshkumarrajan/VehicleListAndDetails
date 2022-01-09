package com.anonymous.vehiclelistanddetails.data.vehicle.repo

import com.anonymous.vehiclelistanddetails.data.vehicle.api.VehicleNetworkService
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.data.vehicle.model.VehicleRemoteResult
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehicleRepositoryImpl(private val api: VehicleNetworkService) : VehicleRepository {
    override suspend fun vehicles(): Flow<RemoteDateResponse<List<VehicleDomain>>?>  = flow {
       val data = convertAPIResponse(
            api.getVehicles(), VehiclesMap()
        )
        emit(data)
    }
}

fun <i, out> convertAPIResponse(
    apiResponse: ApiResponse<i>,
    mapper: APIResponseMap<i, out>
): RemoteDateResponse<out>? {
    var response: RemoteDateResponse<out>? = null

    apiResponse.onSuccess {
        response = RemoteDateResponse.Success(data = mapper.toDomain(this.data))
    }.onError {
        response = RemoteDateResponse.Error<out>(errorMessage = this.errorBody.toString())
    }.onException {
        response = RemoteDateResponse.Error<out>(errorMessage = this.message)
    }

    return response
}


interface APIResponseMap<in input, out output> {
    fun toDomain(In: input): output
}

class VehiclesMap : APIResponseMap<VehicleRemoteResult, List<VehicleDomain>> {
    override fun toDomain(In: VehicleRemoteResult): List<VehicleDomain> =
        In.results.map {
            VehicleDomain(
                it.id ?: "",
                it.displayVariant ?: "",
                it.model ?: "",
                it.make ?: "",
                it.modelYear ?: ""
            )
        }
}