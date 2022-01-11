package com.anonymous.vehiclelistanddetails.ui.vehicles.adapter

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.databinding.VehicleAdapterLayoutBinding
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI

class VehiclesViewHolder(private val item: VehicleAdapterLayoutBinding) : RecyclerView.ViewHolder(item.root) {
    fun setValue(data: VehicleUI?) {
        item.vehicle = data
        item.root.setOnClickListener {
            goToDetails(data?.id?:"")
        }
    }

    private fun goToDetails(id:String){
        val bundle = Bundle()
        bundle.putString("id",id)
        Navigation.findNavController(item.root).navigate(R.id.list_to_details,bundle)
    }
}
