package com.eieimon.carsrent.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.eieimon.carsrent.R


class AboutUsFragment : Fragment() {

    private val TAG = AboutUsFragment::class.java.simpleName


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contentName = view.findViewById<View>(R.id.content_name) as TextView
        val contentAddress = view.findViewById<View>(R.id.content_address) as TextView
        val name = view.findViewById<View>(R.id.name) as TextView
        val description = view.findViewById<View>(R.id.description) as TextView
        val email = view.findViewById<View>(R.id.email) as TextView
        val phone = view.findViewById<View>(R.id.phone) as TextView


        val callUsButton = view.findViewById<View>(R.id.call_us) as Button
        callUsButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + "073838382"))
            startActivity(intent) }

    }

    fun AboutUsFragment() {}
}