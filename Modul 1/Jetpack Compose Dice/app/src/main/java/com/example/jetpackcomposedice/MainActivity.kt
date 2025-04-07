package com.example.jetpackcomposedice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedice.ui.theme.JetpackComposeDiceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeDiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DiceImage(diceValue: Int) {
    Image(
        painter = painterResource(id = getDiceResource(diceValue)),
        contentDescription = "Dice $diceValue",
        modifier = Modifier.size(180.dp)
    )
}

fun getDiceResource(value: Int): Int {
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

@Composable
fun DiceScreen(modifier: Modifier = Modifier) {
    var dice1 by rememberSaveable { mutableStateOf(0) }
    var dice2 by rememberSaveable { mutableStateOf(0) }
    var message by rememberSaveable { mutableStateOf("") }
    var isRolled by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(0.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DiceImage(dice1)
            Spacer(modifier = Modifier.width(0.dp))
            DiceImage(dice2)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                dice1 = Random.nextInt(1, 7)
                dice2 = Random.nextInt(1, 7)
                isRolled = true
                message = if (dice1 == dice2) {
                    "Selamat, anda dapat dadu double!"
                } else {
                    "Anda belum beruntung!"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCE96FF))
        ) {
            Text(
                text = "Roll",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.weight(1f))

        if (isRolled) {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DicePreview() {
    JetpackComposeDiceTheme {
        DiceScreen()
    }
}
