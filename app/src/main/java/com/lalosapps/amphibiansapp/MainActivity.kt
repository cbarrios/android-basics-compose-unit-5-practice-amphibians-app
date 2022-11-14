package com.lalosapps.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lalosapps.amphibiansapp.ui.theme.AmphibiansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansAppTheme {

            }
        }
    }
}