package com.bitcode.fragments3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcode.fragments3.databinding.FragmentABinding

//*** Cyclic dependency
class FragmentA : Fragment()/*, FragmentB.OnCitySetListener*/ {

    private lateinit var binding : FragmentABinding
    var text = ""
    set(value) {
        field = value
        binding.edtName.setText(value)
    }

    interface OnNameSetListener {
        fun onNameSet(name : String)
    }

    var onNameSetListener : OnNameSetListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater)

        //way1
        /*binding.btnSendName.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB)
                .text = binding.edtName.text.toString()
        }*/

        //Way2
        /*binding.btnSendName.setOnClickListener {
            (requireActivity() as MainActivity)
                .setTextToFragmentB(binding.edtName.text.toString())
        }*/

        //way 3
        binding.btnSendName.setOnClickListener {
            onNameSetListener?.onNameSet(binding.edtName.text.toString())
        }

        return binding.root
    }

}