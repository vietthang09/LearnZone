package com.vku.learnzone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import com.vku.learnzone.navigation.Navigation
import com.vku.learnzone.ui.theme.LearnZoneTheme
import com.vku.learnzone.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnZoneTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}
