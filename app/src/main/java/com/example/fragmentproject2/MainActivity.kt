package com.example.fragmentproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentproject2.databinding.ActivityMainBinding
import com.example.fragmentproject2.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFrameToFragment(Home_Fragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.Home -> replaceFrameToFragment(Home_Fragment())

                R.id.search -> replaceFrameToFragment(search_fragment())

                R.id.profile -> replaceFrameToFragment(LoginFragment())

                else -> {

                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }


    }

    fun replaceFrameToFragment(fragment: Fragment){

        var fragmentManager = supportFragmentManager

        var fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)

        fragmentTransaction.commit()
    }
}