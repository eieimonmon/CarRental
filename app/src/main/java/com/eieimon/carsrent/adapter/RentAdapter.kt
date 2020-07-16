package com.eieimon.carsrent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eieimon.carsrent.R
import com.eieimon.carsrent.model.Rent
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.car_record.view.*
import kotlinx.android.synthetic.main.car_show.view.img_car
import kotlinx.android.synthetic.main.car_show.view.txt_car_no
import kotlinx.android.synthetic.main.car_show.view.txt_name

class RentAdapter (var rentsList: List<Rent> = ArrayList()): RecyclerView.Adapter<RentAdapter.RentsViewHolder>() {

    fun update(rentsList: List<Rent>) {
        this.rentsList = rentsList
        notifyDataSetChanged()
    }

    inner class RentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var rent: Rent

        fun bind(rents: Rent) {
            this.rent = rents

            Picasso.get().load("http://car-rental.khaingthinkyi.me/" + rent.car.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(itemView.img_car)
            itemView.txt_name.text = rent.car.category.name
            itemView.txt_car_no.text = rent.car.car_no
            itemView.txt_driver.text = rent.car.driver.name
            itemView.tv_name.text = rent.user_id.name
            itemView.tv_phone.text = rent.user_id.phone_no
            itemView.tv_address.text = rent.user_id.address
            itemView.tv_start.text = rent.start_date
            itemView.tv_end.text = rent.end_date
            if (rent.total_day !=null){
                itemView.tv_date.text = rent.total_day.toString()
            }
            if (rent.total_price !=null){
                itemView.tv_price.text = rent.total_price.toString()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.car_record, parent, false)
        return RentsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rentsList.size
    }

    override fun onBindViewHolder(holder: RentsViewHolder, position: Int) {
        holder.bind(rentsList[position])
    }
}