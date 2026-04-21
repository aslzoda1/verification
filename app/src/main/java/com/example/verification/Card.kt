package com.example.verification

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Card : AppCompatActivity() {
    // Use lateinit to avoid the !! operator
    private lateinit var cardInput: EditText
    private lateinit var checkBtn: Button
    private lateinit var bankName: TextView
    private lateinit var bankLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card)

        cardInput = findViewById(R.id.cardInput)
        checkBtn = findViewById(R.id.checkBtn)
        bankName = findViewById(R.id.bankName)
        bankLogo = findViewById(R.id.bankLogo)

        checkBtn.setOnClickListener {
            identifyBank()
        }
    }

    private fun identifyBank() {
        val cardNumber = cardInput.text.toString().trim()

        // Validation: Ensure we have at least 4 digits to check the BIN
        if (cardNumber.length < 4) {
            bankName.text = "Please enter at least 4 digits"
            bankLogo.visibility = View.GONE
            return
        }

        val bin = cardNumber.substring(0, 4)
        bankLogo.visibility = View.VISIBLE

        when {
            bin.startsWith("9860") -> {
                bankName.text = "Humo (All Banks)"
                bankLogo.setImageResource(R.drawable.logo_humo)
            }
            bin.startsWith("8600") -> {
                bankName.text = "Uzcard (Likely Hamkor Bank)"
                bankLogo.setImageResource(R.drawable.logo_uzcard)
            }
            bin.startsWith("4444") -> {
                bankName.text = "Anor Bank"
                bankLogo.setImageResource(R.drawable.logo_anor)
            }
            else -> {
                bankName.text = "Unknown Bank Card!"
                bankLogo.visibility = View.GONE
            }
        }
    }
}