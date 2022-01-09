package com.anonymous.vehiclelistanddetails.vehicle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anonymous.vehiclelistanddetails.data.vehicle.model.VehicleRemoteResult
import com.anonymous.vehiclelistanddetails.data.vehicle.repo.VehicleRepositoryImpl
import com.anonymous.vehiclelistanddetails.domain.vehicle.repository.VehicleRepository
import com.anonymous.vehiclelistanddetails.data.vehicle.api.VehicleNetworkService
import com.anonymous.vehiclelistanddetails.data.vehicle.model.VehicleRemote
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.nhaarman.mockitokotlin2.given
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class VehicleRepositoryShould {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var api: VehicleNetworkService
    private lateinit var repository: VehicleRepository

    @ExperimentalCoroutinesApi
    @Before
    fun init() {
        repository = VehicleRepositoryImpl(api)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getVehicles_success(): Unit = runBlocking {
        val vehiclesRemoteResult = getTestVehiclesList()
        val response = ApiResponse.Success(Response.success(vehiclesRemoteResult))
        given(api.getVehicles()).willReturn(response)
        val flow: Flow<RemoteDateResponse<List<VehicleDomain>>?> = repository.vehicles()

        var finalResult : List<VehicleDomain>?= null

        when(val res = flow.first()) {
            is RemoteDateResponse.Success -> finalResult  =  res.data
            else -> {}
        }

        assert(finalResult != null)
        assert(finalResult?.size == 2)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getVehicles_failure(): Unit = runBlocking {
        val response = ApiResponse.Success(Response.success(VehicleRemoteResult(emptyList())))
        given(api.getVehicles()).willReturn(response)
        val flow: Flow<RemoteDateResponse<List<VehicleDomain>>?> = repository.vehicles()

        var finalResult : List<VehicleDomain>?= null

        when(val res = flow.first()) {
            is RemoteDateResponse.Success -> finalResult  =  res.data
            else -> {}
        }

        assert(finalResult != null)
        assert(finalResult?.size == 0)
    }

private fun getTestVehiclesList(): VehicleRemoteResult = VehicleRemoteResult(
    listOf(
        VehicleRemote(
            "30073f2a-84b2-5a3f-a105-52c2fcaac169",
            "Jaguar",
            "XF",
            "2018",
            "3L S d V6"
        ),
        VehicleRemote(
            "30073f2a-84b2-5a3f-a105-52c2fcaac169",
            "Jaguar",
            "XF",
            "2018",
            "3L S d V6"
        )
    )
)
}
