package com.example.verification

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find them as View or RelativeLayout, NOT Button
        val btnPassport = findViewById<View>(R.id.Passport)
        val btnPhone = findViewById<View>(R.id.Phone)
        val btnBank = findViewById<View>(R.id.Bank)

        btnPassport.setOnClickListener {
            // Pointing to Password activity
            val intent = Intent(this, Password::class.java)
            startActivity(intent)
        }

        btnPhone.setOnClickListener {
            val intent = Intent(this, Number::class.java)
            startActivity(intent)
        }

        btnBank.setOnClickListener {
            val intent = Intent(this, Card::class.java)
            startActivity(intent)
        }
    }
}