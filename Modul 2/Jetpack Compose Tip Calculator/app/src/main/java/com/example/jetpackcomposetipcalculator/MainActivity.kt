package com.example.jetpackcomposetipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TipCalculatorApp()
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    var billAmount by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("15") }
    var roundUp by remember { mutableStateOf(false) }

    val tip = calculateTip(billAmount, tipPercent.toIntOrNull() ?: 0, roundUp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Calculate Tip",
            fontSize = 22.sp,
            modifier = Modifier.align(Alignment.Start))

        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        TipDropdown(
            selected = tipPercent,
            onChange = { tipPercent = it }
        )

        Row(
            modifier = Modifier.fillMaxWidth(), // ⬅️ stretches across screen
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // ⬅️ pushes content to edges
        ) {
            Text("Round up tip?")
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        Text(
            text = "Tip Amount: $${"%.2f".format(tip)}",
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipDropdown(
    selected: String,
    onChange: (String) -> Unit
) {
    val options = listOf("10", "15", "18", "20")
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            readOnly = true,
            value = "$selected%",
            onValueChange = {},
            label = { Text("Tip Percentage") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { percent ->
                DropdownMenuItem(
                    text = { Text("$percent%") },
                    onClick = {
                        onChange(percent)
                        expanded = false
                    }
                )
            }
        }
    }
}

fun calculateTip(amount: String, percent: Int, roundUp: Boolean): Double {
    val cost = amount.toDoubleOrNull() ?: return 0.0
    var tip = cost * percent / 100
    if (roundUp) tip = ceil(tip)
    return tip
}

@Preview(showBackground = true, name = "Tip Calculator Preview")
@Composable
fun TipCalculatorPreview() {
    MaterialTheme {
        TipCalculatorApp()
    }
}

