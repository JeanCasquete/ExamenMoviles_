package com.jeancasquete.ExamenMoviles_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.jeancasquete.ExamenMoviles_.navigation.NavManager
import com.jeancasquete.ExamenMoviles_.room.MascotasDatabase
import com.jeancasquete.ExamenMoviles_.ui.theme.ExamenMovilesTheme
import com.jeancasquete.ExamenMoviles_.viewmodels.MascotasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenMovilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, MascotasDatabase::class.java, "db_mascotas").build()
                    val dao = database.usuariosDao()
                    
                    val viewModel = MascotasViewModel(dao)
                    
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}
