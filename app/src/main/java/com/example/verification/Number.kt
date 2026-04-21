package com.example.verification

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Number : AppCompatActivity() {

    private lateinit var etPhoneNumber: EditText
    private lateinit var btnIdentify: Button
    private lateinit var ivOperatorLogo: ImageView
    private lateinit var tvOperatorName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_number)

        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnIdentify = findViewById(R.id.btnIdentify)
        ivOperatorLogo = findViewById(R.id.ivOperatorLogo)
        tvOperatorName = findViewById(R.id.tvOperatorName)

        btnIdentify.setOnClickListener {
            val number = etPhoneNumber.text.toString().trim()

            // Check if it starts with +998 and has exactly 13 characters
            if (number.startsWith("+998") && number.length == 13) {
                val code = number.substring(4, 6)
                identifyOperator(code)
            } else {
                Toast.makeText(this, "Enter in format: +998XXXXXXXXX", Toast.LENGTH_SHORT).show()
                ivOperatorLogo.visibility = View.GONE
                tvOperatorName.text = ""
            }
        }
    }

    private fun identifyOperator(code: String) {
        ivOperatorLogo.visibility = View.VISIBLE

        when (code) {
            "90", "91" -> {
                tvOperatorName.text = "Beeline"
                ivOperatorLogo.setImageResource(R.drawable.beeline_logo)
            }
            "93", "94", "50" -> { // Added 50 for Ucell
                tvOperatorName.text = "Ucell"
                ivOperatorLogo.setImageResource(R.drawable.ucell_logo)
            }
            "97", "88" -> {
                tvOperatorName.text = "Mobiuz (UMS)"
                ivOperatorLogo.setImageResource(R.drawable.mobiuz_logo)
            }
            "99", "95", "77", "98" -> {
                tvOperatorName.text = "Uztelecom (UzMobile)"
                ivOperatorLogo.setImageResource(R.drawable.uzmobile_logo)
            }
            "33" -> {
                tvOperatorName.text = "Humans"
                ivOperatorLogo.setImageResource(R.drawable.humans_logo)
            }
            "20" -> { // Added 20 for Oq
                tvOperatorName.text = "Oq"
                // ivOperatorLogo.setImageResource(R.drawable.oq_logo)
            }
            else -> {
                tvOperatorName.text = "Unknown Operator"
                ivOperatorLogo.visibility = View.GONE
            }
        }
    }
}