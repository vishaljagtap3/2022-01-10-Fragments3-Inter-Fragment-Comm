package com.bitcode.fragments3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcode.fragments3.databinding.FragmentBBinding

class FragmentB : Fragment(), FragmentA.OnNameSetListener {

    private lateinit var binding : FragmentBBinding
    var text = ""
    set(value) {
        field = value
        binding.edtCity.setText(field)
    }

    interface OnCitySetListener {
        fun onCitySet(city : String)
    }

    var onCitySetListener : OnCitySetListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater)

        //way 1
        /*binding.btnSendCity.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.fragmentA)  as FragmentA).text =
                binding.edtCity.text.toString()
        }*/

        //way 2
        /*binding.btnSendCity.setOnClickListener {
            (requireActivity() as MainActivity).setTextToFragmentA(
                binding.edtCity.text.toString()
            )
        }*/

        //way 3
        binding.btnSendCity.setOnClickListener {
            onCitySetListener?.onCitySet(binding.edtCity.text.toString())
        }

        return binding.root
    }

    override fun onNameSet(name: String) {
        binding.edtCity.setText(name)
    }
}