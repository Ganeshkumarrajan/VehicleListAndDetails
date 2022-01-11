package com.anonymous.vehiclelistanddetails.ui.vehicles.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI

class VehiclesAdapter : RecyclerView.Adapter<VehiclesViewHolder>() {
    var vehicles: List<VehicleUI>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder =
        VehiclesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.vehicle_adapter_layout,parent,false))

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) =
        holder.setValue(vehicles?.get(position))

    override fun getItemCount(): Int = vehicles?.size ?: 0

    fun setData(d:List<VehicleUI>?){
        vehicles = d
        notifyItemChanged(0)
    }
}
