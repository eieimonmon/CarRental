package com.eieimon.carsrent.ui.carrent

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.provider.SyncStateContract
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.solver.widgets.Helper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eieimon.carsrent.R
import com.eieimon.carsrent.model.City
import com.eieimon.carsrent.ui.city.CityViewModel
import kotlinx.android.synthetic.main.fragment_car_rent.*
import java.util.*
import kotlin.collections.ArrayList


class CarRentFragment : Fragment() {
    private lateinit var carRentViewModel: CarRentViewModel

    private lateinit var cityViewModel: CityViewModel

    private  var cityArray: List<City> = ArrayList()

    lateinit var spinner: Spinner
    lateinit var  Fromspinner: Spinner
    lateinit var  tv_from : String
    lateinit var tv_to : String
     var cityFromId =0
    var cityToId =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_car_rent, container, false)

        Fromspinner = view.findViewById(R.id.from)
        spinner = view.findViewById(R.id.To)

//        view.btnRent.setOnClickListener {
//            makeText(context, spinner?.selectedItem?.toString(),Toast.LENGTH_LONG).show()
//            makeText(context, Fromspinner?.selectedItem?.toString(),Toast.LENGTH_LONG).show()
//        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carRentViewModel = ViewModelProvider(this).get(CarRentViewModel::class.java)
        var rentArgs = arguments?.let { CarRentFragmentArgs.fromBundle(it) }
        var carRent = rentArgs!!.carId

        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        cityViewModel.loadTCity()
        cityViewModel.getCity().observe(viewLifecycleOwner, Observer {result ->
            cityArray = result.cities

            var data: MutableList<String> = ArrayList()

            cityArray.forEach{
                data.add(0,it.name )
            }
            spinner.adapter = context?.let { ArrayAdapter<String>(it, R.layout.support_simple_spinner_dropdown_item,data) }
            Fromspinner.adapter =context?.let { ArrayAdapter<String>(it, R.layout.support_simple_spinner_dropdown_item,data) }
        })

        Fromspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                val fromitem: String = parent?.getItemAtPosition(position).toString()
                tv_from = fromitem

                cityArray.forEach{
                    if(it.name == fromitem){
                        cityFromId = it.id
                    }
                }
            }

        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                val toitem: String = parent?.getItemAtPosition(position).toString()
                tv_to = toitem
                cityArray.forEach{
                    if(it.name == toitem) {
                        cityToId = it.id
                    }
                }
            }
        }


        (activity as AppCompatActivity).supportActionBar?.title = "Car Rental"



            val etStart = view.findViewById<TextView>(R.id.etStart)

            val etEnd = view.findViewById<TextView>(R.id.etEnd)

            val calendar = Calendar.getInstance()
            val y = calendar.get(Calendar.YEAR)
            val m = calendar.get(Calendar.MONTH)
            val d = calendar.get(Calendar.DAY_OF_MONTH)

           etStart.setOnClickListener {
                val datepickerdialog= DatePickerDialog(it.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    //etStart.setText(" "+dayOfMonth + " -" + monthOfYear + "- " + year)
                    etStart.setText(""+year+"-"+monthOfYear+"-"+dayOfMonth)
                }, y, m, d)

                datepickerdialog.show()
            }
            etEnd.setOnClickListener {
                val datepickerdialog= DatePickerDialog(it.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    etEnd.setText(""+year+"-"+monthOfYear+"-"+dayOfMonth)
                }, y, m, d)

                datepickerdialog.show()
            }

            val btnCancel = view.findViewById<Button>(R.id.btnCancel)
            btnCancel.setOnClickListener {
                var carCancel = " "
                var cancel = CarRentFragmentDirections.actionCarRentFragmentToNavigationHome(carCancel)
                findNavController().navigate(cancel)
            }

        btnRent.setOnClickListener {

            var userName = etName.text.toString()
            var phone = etPhone.text.toString().toInt()
            var address = etAddress.text.toString()
            var startDate = etStart.text.toString()
            var endDate = etEnd.text.toString()
            var fromRoute = cityFromId.toString().toInt()
            var toRoute = cityToId.toString().toInt()
            var price = etprice.text.toString()
            Log.d("user" ,fromRoute.toString())

            if( userName !=null && phone !=null && address !=null && startDate !=null && endDate !=null && fromRoute !=null && toRoute !=null && price !=null ){

                observeRent(carRent, userName, phone, address, startDate, endDate, fromRoute, toRoute, price)

                var carRecord = " "
                var record = CarRentFragmentDirections.actionCarRentFragmentToRecordFragment2(carRecord)
                findNavController().navigate(record)


            }else if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(phone.toString()) || TextUtils.isEmpty(address) || TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate) || TextUtils.isEmpty(fromRoute.toString()) || TextUtils.isEmpty(toRoute.toString()) || TextUtils.isEmpty(price)){
                return@setOnClickListener
                Toast.makeText(context,"fill data", Toast.LENGTH_LONG).show()
            }

        }

    }


    fun observeRent(carId:Int,name:String, phone_no:Int, address:String, startDate:String, endDate:String, city_from_id:Int, city_to_id: Int,price:String){

        carRentViewModel.loadCarRent(carId,name,phone_no,address,startDate,endDate,city_from_id,city_to_id,price)
        carRentViewModel.postCarRent().observe(viewLifecycleOwner, Observer {
                Toast.makeText(context,it,Toast.LENGTH_LONG).show()
        })

    }
}

