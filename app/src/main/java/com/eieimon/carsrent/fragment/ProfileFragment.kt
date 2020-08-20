package com.eieimon.carsrent.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.eieimon.carsrent.R


class ProfileFragment : Fragment() {

    private val TAG = ProfileFragment::class.java.simpleName



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title=" Profile"

        val name = view.findViewById<View>(R.id.user_name) as TextView
        val email = view.findViewById<View>(R.id.user_email) as TextView
        val phone = view.findViewById<View>(R.id.user_phone) as TextView
        val address = view.findViewById<View>(R.id.user_address) as TextView

        
    }
    fun ProfileFragment() {}


}