package com.bitcode.fragments3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA : FragmentA
    private lateinit var fragmentB : FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = supportFragmentManager.findFragmentById(R.id.fragmentA) as FragmentA
        fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB

        //3.1
        //fragmentA.onNameSetListener = MyOnNameSetListener()

        //3.2
        fragmentA.onNameSetListener = fragmentB

        fragmentB.onCitySetListener = MyOnCitySetListener()
    }

    inner class MyOnCitySetListener : FragmentB.OnCitySetListener {
        override fun onCitySet(city: String) {
            Toast.makeText(this@MainActivity, city, Toast.LENGTH_LONG).show()
            fragmentA.text = city
        }
    }

    //way 3.1
    inner class MyOnNameSetListener : FragmentA.OnNameSetListener {
        override fun onNameSet(name: String) {
            Toast.makeText(this@MainActivity, name, Toast.LENGTH_LONG).show()
            fragmentB.text = name
        }
    }

    fun setTextToFragmentA(text : String) {
        fragmentA.text = text
    }

    fun setTextToFragmentB(text : String) {
        fragmentB.text = text
    }
}