package com.praktek.fragmentactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


class FragmentSecond : Fragment() {
    // TODO: Rename and change types of parameters
    private var iniViewModel : IniViewModel? = null
    private var txtName: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iniViewModel = ViewModelProviders.of(requireActivity()).get(IniViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)
        iniViewModel !!.name.observe(requireActivity(), Observer { s -> txtName !!.text = s})
    }

    companion object {

        fun newInstance(): FragmentSecond {
            return FragmentSecond()
        }

    }
}