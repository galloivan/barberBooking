package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment

class ServiceSelectionTimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.service_time_selection, container, false)


        val selectedBarber = arguments?.getString("selectedBarber") ?: "No barber selected"
        val selectedService = arguments?.getString("selectedService") ?: "No service selected"


        val timePicker = view.findViewById<TimePicker>(R.id.timePicker)
        timePicker.setIs24HourView(true)


        val editTextUserName = view.findViewById<EditText>(R.id.editTextUserName)
        val editTextEmail = view.findViewById<EditText>(R.id.editTextEmail)

        val btnConfirm = view.findViewById<Button>(R.id.btnConfirm)
        btnConfirm.setOnClickListener {

            val datePicker = view.findViewById<DatePicker>(R.id.datePicker)
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1
            val year = datePicker.year
            val hour = timePicker.hour
            val minute = timePicker.minute


            val appointmentDate = "$day/$month/$year"
            val appointmentTime = String.format("%02d:%02d", hour, minute)


            val customerName = editTextUserName.text.toString()
            val customerEmail = editTextEmail.text.toString()


            if (customerName.isEmpty() || customerEmail.isEmpty()) {
                Toast.makeText(context, "Please enter your name and email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            showConfirmationFragment(customerName, customerEmail, selectedBarber, selectedService, appointmentDate, appointmentTime)
        }

        return view
    }

    private fun showConfirmationFragment(name: String, email: String, barber: String, service: String, date: String, time: String) {
        val bundle = Bundle().apply {
            putString("customerName", name)
            putString("customerEmail", email)
            putString("selectedBarber", barber)
            putString("selectedService", service)
            putString("appointmentDate", date)
            putString("appointmentTime", time)
        }

        val confirmationFragment = ServiceConfirmationFragment().apply {
            arguments = bundle
        }

        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, confirmationFragment)
            addToBackStack(null)
            commit()
        }
    }
}
