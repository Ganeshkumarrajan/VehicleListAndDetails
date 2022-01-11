package com.anonymous.vehiclelistanddetails.vehicle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCase
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehiclesViewModel
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class VehicleViewModelShould {
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var vehicleUseCase: VehicleUseCase

    private lateinit var viewModel: VehiclesViewModel

    @ExperimentalCoroutinesApi
    @Test
    fun getVehicles() = runBlockingTest {
        val response = listOf(VehicleDomain("", "", "", "", ""))
        val flowData = flow<RemoteDateResponse<List<VehicleDomain>>> {
            this.emit(RemoteDateResponse.Success(response))
        }

        given(vehicleUseCase.vehicles()).willReturn(flowData)

        viewModel = VehiclesViewModel(vehicleUseCase)
        var data: UIResult<List<VehicleUI>>? = null
        viewModel.vehiclesLiveData.observeForever {
            data = it
        }
        assert(data != null)
    }

}
