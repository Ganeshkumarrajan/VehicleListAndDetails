package com.anonymous.vehiclelistanddetails.data.util

import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess

fun <i, out> convertAPIResponse(
    apiResponse: ApiResponse<i>,
    mapper: APIResponseMap<i, out>
): RemoteDateResponse<out>? {
    var response: RemoteDateResponse<out>? = null

    apiResponse.onSuccess {
        response = RemoteDateResponse.Success(data = mapper.toDomain(this.data))
    }.onError {
        response = RemoteDateResponse.Error(errorMessage = this.errorBody.toString())
    }.onException {
        response = RemoteDateResponse.Error(errorMessage = this.message)
    }

    return response
}
