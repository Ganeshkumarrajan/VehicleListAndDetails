package com.anonymous.vehiclelistanddetails.ui.di

import com.anonymous.vehiclelistanddetails.data.vehicle.api.VehicleNetworkService
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val  NetworkModule = module{
    single { provideMovieAPIService(retrofit = get()) }
    single { provideRetrofit(okHttpClient = get(), url = "https://www.cazoo.co.uk/api/") }
    single { provideOkHttpClient() }
}

const val SECONDS = 60L

internal fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .connectTimeout(SECONDS, TimeUnit.SECONDS)
        .readTimeout(SECONDS, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

internal fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
        .build()
}

internal fun provideMovieAPIService(retrofit: Retrofit): VehicleNetworkService =
    retrofit.create(VehicleNetworkService::class.java)