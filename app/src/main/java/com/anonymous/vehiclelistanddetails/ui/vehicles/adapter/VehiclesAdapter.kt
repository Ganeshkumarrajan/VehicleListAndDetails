package com.anonymous.vehiclelistanddetails.ui.vehicles.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.databinding.VehicleAdapterLayoutBinding
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI

class VehiclesAdapter : RecyclerView.Adapter<VehiclesViewHolder>() {
    var vehicles: List<VehicleUI>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder =
        VehiclesViewHolder(DataBindingUtil.inflate<VehicleAdapterLayoutBinding>(LayoutInflater.from(parent.context),
            R.layout.vehicle_adapter_layout,parent,false))

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) =
        holder.setValue(vehicles?.get(position))



    override fun getItemCount(): Int = vehicles?.size ?: 0

    fun setData(d:List<VehicleUI>?){
        vehicles = d
        notifyItemChanged(0)
    }
}

class VehiclesViewHolder(private val item: VehicleAdapterLayoutBinding) : RecyclerView.ViewHolder(item.root) {
    fun setValue(data: VehicleUI?) {
        item.vehicle = data
        item.root.setOnClickListener {
            data?.id
        }
    }
}
