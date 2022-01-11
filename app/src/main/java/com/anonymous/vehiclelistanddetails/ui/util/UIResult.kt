package com.anonymous.vehiclelistanddetails.ui.util

sealed class UIResult <T>(val data: T? = null,val showLoading:Boolean){
    data class Success<T>(val t: T?,val b: Boolean) : UIResult<T>(t,b)
    data class Loading<T>(val b: Boolean) : UIResult<T>(null,b)
    data class Error<T>(val t: T?,val b: Boolean) : UIResult<T>(t,b)
}
