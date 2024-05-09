package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ServiceConfirmationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.service_confirmation, container, false)

        val customerName = arguments?.getString("customerName")
        val customerEmail = arguments?.getString("customerEmail")
        val selectedBarber = arguments?.getString("selectedBarber")
        val selectedService = arguments?.getString("selectedService")
        val appointmentDate = arguments?.getString("appointmentDate")
        val appointmentTime = arguments?.getString("appointmentTime")

        val detailsTextView: TextView = view.findViewById(R.id.appointmentDetails)
        detailsTextView.text = getString(R.string.confirmation_details, customerName, selectedBarber, selectedService, appointmentDate, appointmentTime, customerEmail)

        return view
    }
}
