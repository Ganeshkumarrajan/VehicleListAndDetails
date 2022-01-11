package com.anonymous.vehiclelistanddetails.ui.vehicles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle.model.VehicleDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle.use_case.VehicleUseCase
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VehiclesViewModel(private val vehicleUseCase: VehicleUseCase) : ViewModel() {
    val vehiclesLiveData: MutableLiveData<UIResult<List<VehicleUI>>> = MutableLiveData()

    init {
        getVehicles()
    }

    private fun getVehicles() {
        viewModelScope.launch {
            vehicleUseCase.vehicles().collect {
                vehiclesLiveData.value = UIResult.Loading(true)
                parseVehiclesResponse(it)
            }
        }
    }

    private fun parseVehiclesResponse(result: RemoteDateResponse<List<VehicleDomain>>?) {
        when (result) {
            is RemoteDateResponse.Success -> {
                vehiclesLiveData.value = UIResult.Success(convertToVehicleDomainToVehicleUI(result.data), false)
            }
            is RemoteDateResponse.Error -> {
                vehiclesLiveData.value = UIResult.Loading(false)
            }
            else -> {}
        }
    }

    private fun convertToVehicleDomainToVehicleUI(result: List<VehicleDomain>): List<VehicleUI> =
        result.map { vehicle ->
            vehicle.toUI()
        }

}
