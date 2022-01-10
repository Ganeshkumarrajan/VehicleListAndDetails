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

    fun getVehicles() {
        viewModelScope.launch {
             vehicleUseCase.vehicles().collect {
                 vehiclesLiveData.value =  UIResult.Loading(true)
                 parseVehicles(it)
             }
        }
    }

    private fun parseVehicles(data:RemoteDateResponse<List<VehicleDomain>>?){
        when(data){
           is  RemoteDateResponse.Success -> {
               val vehicles =  data.data.map { vehicle ->
                   vehicle.toUI()
               }

               vehiclesLiveData.value =  UIResult.Success(vehicles,false)
           }
           is RemoteDateResponse.Error -> {
               vehiclesLiveData.value =  UIResult.Loading(false)
           }
            else -> {}
        }
    }
}
