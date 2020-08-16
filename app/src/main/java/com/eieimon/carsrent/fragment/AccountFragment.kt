package com.eieimon.carsrent.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eieimon.carsrent.R
import com.eieimon.carsrent.fragment.AccountFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class AccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.hide()

        val navigationView = view.findViewById<NavigationView>(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            if (id == R.id.action_profile) {
                val profile =" "
                val directProfile =
                    AccountFragmentDirections.actionNavigationAccountToProfileFragment(
                        profile
                    )
                findNavController().navigate(directProfile)

            } else if (id == R.id.action_about) {
                val about =""
                val directAbout =AccountFragmentDirections.actionNavigationAccountToAboutUsFragment(about)
                findNavController().navigate(directAbout)

            } else if (id == R.id.action_share) {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)


            } else if (id == R.id.action_logOut) {
                val logout =""
                val directLogout =
                    AccountFragmentDirections.actionNavigationAccountToAccountActivity(
                        logout
                    )
                findNavController().navigate(directLogout)

            }
            true
        })

    }
    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.home, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        /*if (id == R.id.action_settings) {
            return true;
        }*/return super.onOptionsItemSelected(item)
    }
}

private fun NavigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener) {


}


