package com.anonymous.vehiclelistanddetails

import android.app.Application
import com.anonymous.vehiclelistanddetails.ui.di.NetworkModule
import com.anonymous.vehiclelistanddetails.ui.di.RepositoryModule
import com.anonymous.vehiclelistanddetails.ui.di.UseCaseModule
import com.anonymous.vehiclelistanddetails.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VehicleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VehicleApp)
            modules(
                NetworkModule,
                RepositoryModule,
                UseCaseModule,
                viewModelModule
            )
        }
    }
}