package com.anonymous.vehiclelistanddetails.vehicle


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCase
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehiclesViewModel
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.inOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class VehicleListFeature {
    private lateinit var viewModel: VehiclesViewModel
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var vehicleUseCase: VehicleUseCase

    private val vehicleUI = listOf(VehicleUI(
        "sad", "display variant",
        "model 123", "BMW", "https://imageURL"
    ))

    private val vehiclesResult = UIResult.Success(vehicleUI, false)
    private val showLoading = UIResult.Loading<List<VehicleUI>>(true)

    @Mock
    private lateinit var vehiclesLiveDataObserver: Observer<UIResult<List<VehicleUI>>>

    @ExperimentalCoroutinesApi
    @Before
    fun init(){
        viewModel = VehiclesViewModel(vehicleUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getVehicleList() = runBlockingTest {
        val successData = flow<RemoteDateResponse<List<VehicleDomain>>> {
            emit(RemoteDateResponse.Success(listOf(VehicleDomain("sad", "display variant",
                "model 123", "BMW", "https://imageURL"))))
        }

        given(vehicleUseCase.vehicles()).willReturn(successData)
        viewModel.vehiclesLiveData.observeForever(vehiclesLiveDataObserver)
        viewModel.getVehicles()
        val order = inOrder(vehiclesLiveDataObserver)
        order.verify(vehiclesLiveDataObserver).onChanged(showLoading)
        order.verify(vehiclesLiveDataObserver).onChanged(vehiclesResult)
    }
}

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher) {
    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}
