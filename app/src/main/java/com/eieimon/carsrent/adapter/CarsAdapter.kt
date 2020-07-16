package com.eieimon.carsrent.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eieimon.carsrent.R
import com.eieimon.carsrent.model.Car
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.car_show.view.*

class CarsAdapter(var carsList: List<Car> = ArrayList()): RecyclerView.Adapter<CarsAdapter.CarsRentViewHolder>() {

    var CarShowClickListener: ClickListener? = null

    interface ClickListener{

        fun onClick(cars: Car)
    }

    fun setOnClickListener(clickListener: ClickListener){
        this.CarShowClickListener = clickListener
    }

    fun update(carsList: List<Car>) {
        this.carsList = carsList
        notifyDataSetChanged()
    }

    inner class CarsRentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{

        lateinit var car:Car

        fun bind(cars: Car){
            this.car = cars

            Picasso.get().load("http://car-rental.khaingthinkyi.me/"+car.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(itemView.img_car)
            itemView.txt_name.text = car.category.name
            itemView.txt_car_no.text = car.car_no
            itemView.txt_model.text = car.model
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            CarShowClickListener?.onClick(car)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsRentViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.car_show, parent, false)
        return CarsRentViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Size", carsList.size.toString())
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarsRentViewHolder, position: Int) {
        holder.bind(carsList[position])
    }

}