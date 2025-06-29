package com.app.latihan_jetpack

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.app.praktikum_kel1_2.navigation.SetupNavGraph
import com.app.latihan_jetpack.ui.theme.LatihanJetpackTheme


/*
* Main Activity For a Develop Apps (Application Entry Point)
 */
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LatihanJetpackTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController)
                }
            }
        }
    }

//Menerapkan Mode Preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LatihanJetpackTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController)
    }
}