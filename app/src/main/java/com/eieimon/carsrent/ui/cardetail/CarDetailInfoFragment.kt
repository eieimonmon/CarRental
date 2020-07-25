package com.eieimon.carsrent.ui.cardetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eieimon.carsrent.R
import com.eieimon.carsrent.model.Car
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_car_detail_info.*

class CarDetailInfoFragment : Fragment() {

    private lateinit var carDetailViewModel: CarDetailInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_car_detail_info, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carDetailViewModel = ViewModelProvider(this).get(CarDetailInfoViewModel::class.java)
        var detailArg = arguments?.let { CarDetailInfoFragmentArgs.fromBundle(it) }
        var carDetail = detailArg!!.CarDetail
        var carName = detailArg.CarName
        observeDetail(carDetail!!)
        (activity as AppCompatActivity).supportActionBar?.title = carName

        btnBook.setOnClickListener{
            var action = CarDetailInfoFragmentDirections.actionCarDetailInfoFragmentToCarRentFragment(carDetail.id)
            findNavController().navigate(action)
        }


        val callBack: OnBackPressedCallback =

            object : OnBackPressedCallback(true /* enabled by default */) {

                override fun handleOnBackPressed() {

                    findNavController().popBackStack(R.id.navigation_home, false)

                    // Handle the back button event

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callBack)
    }

    private fun observeDetail(carDetail: Car) {
        var baseUrl ="http://car-rental.khaingthinkyi.me/"
        carDetailViewModel.loadCarDetail()
        carDetailViewModel.getCarDetail().observe(viewLifecycleOwner, Observer {
            Picasso.get()
                .load(baseUrl+carDetail.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(Image)
            txtName.text = carDetail.category.name
            txtCarNO.text = carDetail.car_no
            txtCapicity.text = carDetail.capacity
            txtModel.text = carDetail.model
            txtColor.text = carDetail.color
            txtDriver.text = carDetail.driver.name
            txtDescription.text = carDetail.description

        })
    }

}






