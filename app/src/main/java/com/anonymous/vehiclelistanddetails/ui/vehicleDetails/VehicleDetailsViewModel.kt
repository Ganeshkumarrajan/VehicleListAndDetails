package com.anonymous.vehiclelistanddetails.ui.vehicleDetails

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.vehiclelistanddetails.domain.util.RemoteDateResponse
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.model.VehicleDetailsDomain
import com.anonymous.vehiclelistanddetails.domain.vehicle_details.use_case.VehicleDetailsUseCase
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VehicleDetailsViewModel(
    private val vehicleUseCase: VehicleDetailsUseCase,
    private val context: Context
) : ViewModel() {
    val vehicleDetailsLiveData: MutableLiveData<UIResult<VehicleDetailsUI>> = MutableLiveData()

    fun getVehicleDetails(id: String) {
        viewModelScope.launch {
            vehicleUseCase.vehicleDetails(id).collect {
                parseVehicleDetailsResponse(it)
            }
        }
    }

    private fun parseVehicleDetailsResponse(result: RemoteDateResponse<VehicleDetailsDomain>?) {
        when (result) {
            is RemoteDateResponse.Success -> {
                vehicleDetailsLiveData.value =
                    UIResult.Success(convertToVehicleDomainToVehicleUI(result.data), false)
            }
            is RemoteDateResponse.Error -> {
                vehicleDetailsLiveData.value = UIResult.Error(null,false)
            }
            else -> {}
        }
    }

    private fun convertToVehicleDomainToVehicleUI(result: VehicleDetailsDomain): VehicleDetailsUI =
        result.toUI(context)

}
