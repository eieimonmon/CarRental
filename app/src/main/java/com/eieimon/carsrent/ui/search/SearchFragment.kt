package com.eieimon.carsrent.ui.search

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eieimon.carsrent.R
import com.eieimon.carsrent.adapter.CarsAdapter
import com.eieimon.carsrent.model.Car
import com.eieimon.carsrent.ui.home.HomeFragmentDirections
import com.eieimon.carsrent.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), CarsAdapter.ClickListener{

    private lateinit var carViewModel: HomeViewModel
    private lateinit var carAdapter: CarsAdapter

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var root = inflater.inflate(R.layout.fragment_search, container, false)
           return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Search"

        search_recycler.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        carAdapter = CarsAdapter()
        search_recycler.adapter = carAdapter

        carAdapter.setOnClickListener(this)

        val btnSearch = view.findViewById<ImageButton>(R.id.img_btn_search)
        btnSearch.setOnClickListener{
            val search = etSearch.text.toString()

            observeViewModel()
        }

    }

    fun observeViewModel() {
        var carShowViewModel: HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        carShowViewModel.loadCarShow()
        carShowViewModel.getCarShow().observe(viewLifecycleOwner, Observer {
            search_recycler.visibility = View.VISIBLE
            carAdapter.update(it)

        })
        carShowViewModel.getLoadError().observe(viewLifecycleOwner, Observer {
            search_recycler.visibility = View.GONE

        })

    }

    override fun onClick(cars: Car) {
        var direction = SearchFragmentDirections.actionNavigationSearchToCarDetailInfoFragment(cars,cars.category.name)
        findNavController().navigate(direction)
    }


}