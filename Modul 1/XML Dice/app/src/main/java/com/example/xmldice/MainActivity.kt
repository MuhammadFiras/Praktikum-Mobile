package com.example.xmldice

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get views from XML
        val dice1: ImageView = findViewById(R.id.imageView1)
        val dice2: ImageView = findViewById(R.id.imageView2)
        val rollButton: Button = findViewById(R.id.button)
        val messageText: TextView = findViewById(R.id.textView)

        rollButton.setOnClickListener {
            // Generate random numbers
            val dice1Value = Random.nextInt(1, 7)
            val dice2Value = Random.nextInt(1, 7)

            // Update images
            dice1.setImageResource(getDiceResource(dice1Value))
            dice2.setImageResource(getDiceResource(dice2Value))

            // Update message
            if (dice1Value == dice2Value) {
                messageText.text = "Selamat, anda dapat dadu double!"
            } else {
                messageText.text = "Anda belum beruntung!"
            }

            messageText.visibility = TextView.VISIBLE
        }
    }

    // Function to get the correct dice image
    private fun getDiceResource(value: Int): Int {
        return when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_0
        }
    }
}