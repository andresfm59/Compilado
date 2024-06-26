package com.example.compilado.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compilado.ui.theme.CompiladoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompiladoTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),

                ) {
                    Text(
                        text = "Notificaciones",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}