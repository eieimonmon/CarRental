package com.eieimon.carsrent.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eieimon.carsrent.R
import com.eieimon.carsrent.adapter.CarsAdapter
import com.eieimon.carsrent.model.Car
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),CarsAdapter.ClickListener {

//    private lateinit var homeViewModel: HomeViewModel
    private lateinit var carAdapter: CarsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_car_show.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        carAdapter = CarsAdapter()
        recycler_car_show.adapter = carAdapter
        carAdapter.setOnClickListener(this)
        observeViewModel()

    }

    fun observeViewModel() {
        val carShowViewModel: HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        carShowViewModel.loadCarShow()
        carShowViewModel.getCarShow().observe(viewLifecycleOwner, Observer {
            recycler_car_show.visibility = View.VISIBLE
            carAdapter.update(it)

        })
        carShowViewModel.getLoadError().observe(viewLifecycleOwner, Observer {
            recycler_car_show.visibility = View.GONE

        })

    }

    override fun onClick(cars: Car) {
        var direction = HomeFragmentDirections.actionNavigationHomeToCarDetailInfoFragment(cars,cars.category.name)
        findNavController().navigate(direction)
    }
}