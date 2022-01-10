package com.anonymous.vehiclelistanddetails.ui.vehicles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.vehiclelistanddetails.R
import com.anonymous.vehiclelistanddetails.ui.util.UIResult
import com.anonymous.vehiclelistanddetails.ui.vehicles.adapter.VehiclesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class VehiclesFragment : Fragment() {
    private lateinit var adapter: VehiclesAdapter
    private var item: View? = null
    private val viewModel by viewModel<VehiclesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        item = inflater.inflate(R.layout.vahicles_fragment_layout,container,false)
        return item
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        adapter = VehiclesAdapter()
        collectVehicles()
    }

    private fun collectVehicles(){
        viewModel.getVehicles()
    }

    private fun setObserver(){
        viewModel.vehiclesLiveData.observeForever {
            onVehiclesDataReceived(it)
        }
    }

    private fun onVehiclesDataReceived(result:UIResult<List<VehicleUI>>){
        when(result){
            is UIResult.Success -> {
                val recycler = item?.findViewById<RecyclerView>(R.id.vehiclesRecycler)
                recycler?.adapter = adapter
                recycler?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
                adapter.setData(result.data)
            }
            is UIResult.Loading -> {}
        }
    }
}