package com.eieimon.carsrent.ui.record

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.eieimon.carsrent.R
import com.eieimon.carsrent.adapter.CarsAdapter
import com.eieimon.carsrent.adapter.RentAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_record.*
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class RecordFragment : Fragment() {

    private lateinit var recordViewModel: RecordViewModel
    private lateinit var recordAdapter: RentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_record, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_car_record.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recordAdapter = RentAdapter()
        recycler_car_record.adapter = recordAdapter

        observeRecord()

        (activity as AppCompatActivity).supportActionBar?.title = "Record Data"
    }

     fun observeRecord() {
        recordViewModel = ViewModelProvider1(this).get(RecordViewModel::class.java)
         recordViewModel.loadCarRecord()
         recordViewModel.getCarRecord().observe(viewLifecycleOwner, Observer {
             recycler_car_record.visibility = View.VISIBLE
             Log.d("rents", it.toString())
             recordAdapter.update(it)
         })
         recordViewModel.getLoadError().observe(viewLifecycleOwner, Observer {
             recycler_car_show.visibility = View.GONE

         })
    }
}