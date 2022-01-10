package com.anonymous.vehiclelistanddetails.ui.vehicles.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.ui.vehicles.VehicleUI

class VehiclesAdapter : RecyclerView.Adapter<VehiclesViewHolder>() {
    var vehicles: List<VehicleUI>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder =
        VehiclesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vehicle_adapter_layout, parent, false)
        )

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) =
        holder.setValue(vehicles?.get(position))


    override fun getItemCount(): Int = vehicles?.size ?: 0

    fun setData(d:List<VehicleUI>?){
        vehicles = d
        notifyItemChanged(0)
    }
}

class VehiclesViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
    fun setValue(data: VehicleUI?) {
            item.findViewById<TextView>(R.id.name).text = data?.displayVariant
    }
}