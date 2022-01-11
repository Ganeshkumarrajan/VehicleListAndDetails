package com.anonymous.vehiclelistanddetails.data.util

interface APIResponseMap<in input, out output> {
    fun toDomain(In: input): output
}