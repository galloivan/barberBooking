package com.example.finalproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInButton: Button = findViewById(R.id.signInButton)
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val browseAsGuestButton: Button = findViewById(R.id.browseAsGuestButton)
        val fragmentContainer: FragmentContainerView = findViewById(R.id.fragmentContainer)

        signInButton.setOnClickListener {

        }

        signUpButton.setOnClickListener {

        }

        browseAsGuestButton.setOnClickListener {

            signInButton.visibility = View.GONE
            signUpButton.visibility = View.GONE
            browseAsGuestButton.visibility = View.GONE
            findViewById<View>(R.id.titleTextView).visibility = View.GONE


            fragmentContainer.visibility = View.VISIBLE


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, ServiceSelectionFragment())

                commit()
            }
        }
    }
}
