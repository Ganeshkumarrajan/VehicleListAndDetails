package com.anonymous.vehiclelistanddetails.domain.util

sealed class RemoteDateResponse<T>() {
    data class Success<T>(var data:T): RemoteDateResponse<T>()
    data class Error<T>(val errorMessage:String?):RemoteDateResponse<T>()
}
