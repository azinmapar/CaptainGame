package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){

    // * 'remember' is a tracker of things that are changing and the changes need to update in the ui
    // * and because of it being a val it needs to contain a mutable value

    val treasuresFound = remember { mutableIntStateOf(0) }
    val sailedDirection = remember { mutableStateOf("North") }

    Column {
        Text(text = "Treasures Found : ${treasuresFound.intValue}")
        Text(text = "Direction Sailed : ${sailedDirection.value}")
        Button(onClick = {
            sailedDirection.value = "North"
            if (Random.nextBoolean()){
                treasuresFound.intValue++
            }
        }) {
            Text(text = "Sail North")
        }
        Button(onClick = {
            sailedDirection.value = "East"
            if (Random.nextBoolean()){
                treasuresFound.intValue++
            }
        }) {
            Text(text = "Sail East")
        }
        Button(onClick = {
            sailedDirection.value = "West"
            if (Random.nextBoolean()){
                treasuresFound.intValue++
            }
        }) {
            Text(text = "Sail West")
        }
        Button(onClick = {
            sailedDirection.value = "South"
            if (Random.nextBoolean()) {
                treasuresFound.intValue++
            }
        }) {
            Text(text = "Sail South")
        }
    }


}