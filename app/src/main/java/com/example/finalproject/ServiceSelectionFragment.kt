package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.CheckBox
import androidx.fragment.app.Fragment

class ServiceSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_service_selection, container, false)

        val continueButton = view.findViewById<Button>(R.id.continueButton)
        continueButton.setOnClickListener {
            val selectedBarber = getSelectedBarber(view)
            val selectedService = getSelectedService(view)
            showTimeSelectionFragment(selectedBarber, selectedService)
        }

        return view
    }

    private fun getSelectedBarber(view: View): String {
        val barber1 = view.findViewById<RadioButton>(R.id.barber1)
        val barber2 = view.findViewById<RadioButton>(R.id.barber2)
        val barber3 = view.findViewById<RadioButton>(R.id.barber3)

        return when {
            barber1.isChecked -> barber1.text.toString()
            barber2.isChecked -> barber2.text.toString()
            barber3.isChecked -> barber3.text.toString()
            else -> "No barber selected" // Handle no selection case appropriately
        }
    }

    private fun getSelectedService(view: View): String {
        val serviceCut = view.findViewById<CheckBox>(R.id.serviceCut)
        val serviceBeard = view.findViewById<CheckBox>(R.id.serviceBeard)
        val serviceCutAndBeard = view.findViewById<CheckBox>(R.id.serviceCutAndBeard)

        // Simplified: assuming only one service can be selected at a time
        return when {
            serviceCut.isChecked -> serviceCut.text.toString()
            serviceBeard.isChecked -> serviceBeard.text.toString()
            serviceCutAndBeard.isChecked -> serviceCutAndBeard.text.toString()
            else -> "No service selected" // Handle no selection case appropriately
        }
    }

    private fun showTimeSelectionFragment(selectedBarber: String, selectedService: String) {
        val bundle = Bundle().apply {
            putString("selectedBarber", selectedBarber)
            putString("selectedService", selectedService)
        }

        val timeFragment = ServiceSelectionTimeFragment().apply {
            arguments = bundle
        }

        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragmentContainer, timeFragment)
            addToBackStack(null)
            commit()
        }
    }
}
