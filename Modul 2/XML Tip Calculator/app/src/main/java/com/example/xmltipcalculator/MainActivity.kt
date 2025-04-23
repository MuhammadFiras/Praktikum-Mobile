package com.example.xmltipcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var billAmountInput: EditText
    private lateinit var tipDropdown: MaterialAutoCompleteTextView
    private lateinit var roundUpSwitch: Switch
    private lateinit var tipResultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        billAmountInput = findViewById(R.id.billAmountInput)
        tipDropdown = findViewById(R.id.tipPercentageDropdown)
        roundUpSwitch = findViewById(R.id.roundUpSwitch)
        tipResultText = findViewById(R.id.tipResultText)

        // Set up dropdown
        val tipOptions = listOf("10%", "15%", "18%", "20%")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tipOptions)
        tipDropdown.setAdapter(adapter)
        tipDropdown.setText(tipOptions[1], false) // Default to 15%

        // Listeners
        billAmountInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = updateTip()
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        tipDropdown.setOnItemClickListener { _, _, _, _ -> updateTip() }

        roundUpSwitch.setOnCheckedChangeListener { _, _ -> updateTip() }

        updateTip()
    }

    private fun updateTip() {
        val cost = billAmountInput.text.toString().toDoubleOrNull() ?: 0.0
        val percent = tipDropdown.text.toString().replace("%", "").toIntOrNull() ?: 0
        val roundUp = roundUpSwitch.isChecked

        var tip = cost * percent / 100
        if (roundUp) tip = ceil(tip)

        tipResultText.text = "Tip Amount: $%.2f".format(tip)
    }
}
