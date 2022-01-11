package com.anonymous.vehiclelistanddetails.ui.vehicleDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anonymous.vehiclelistanddetails.databinding.VahicleDetailsFragmentLayoutBinding
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil
import com.anonymous.vehiclelistanddetails.R


class VehicleDetailsFragment : Fragment() {
    private val viewModel by viewModel<VehicleDetailsViewModel>()
    private lateinit var binding: VahicleDetailsFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(
            inflater, R.layout.vahicle_details_fragment_layout, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelObserver()
         arguments?.getString("id")?.let {
             viewModel.getVehicleDetails(it)
         }
    }

    private fun viewModelObserver(){
        viewModel.vehicleDetailsLiveData.observeForever {
            onVehiclesDataReceived(it)
        }
    }

    private fun onVehiclesDataReceived(result:UIResult<VehicleDetailsUI>){
        when(result){
            is UIResult.Success -> {
                binding.vehicle = result.data
            }
            is UIResult.Error -> {
                Toast.makeText(activity,"No Data found",Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
    }

}
