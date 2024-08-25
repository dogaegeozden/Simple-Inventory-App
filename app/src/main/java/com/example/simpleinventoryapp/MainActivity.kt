package com.example.simpleinventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.simpleinventoryapp.ui.screens.MainScreen
import com.example.simpleinventoryapp.ui.theme.SimpleInventoryAppTheme
import com.example.simpleinventoryapp.ui.viewmodels.InventoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inventoryViewModel = ViewModelProvider(this)[InventoryViewModel::class.java]

        setContent {
            SimpleInventoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ){
                    MainScreen(inventoryViewModel)
                }
            }
        }
    }
}
