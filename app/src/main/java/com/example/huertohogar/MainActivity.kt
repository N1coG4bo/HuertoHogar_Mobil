package com.example.huertohogar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.huertohogar.navigation.AppNavigation
import com.example.huertohogar.ui.theme.HuertoHogarTheme // O el nombre que tenga tu tema por defecto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí llamamos a nuestro mapa de navegación
            // Nota: Si no has creado un Theme personalizado, puedes quitar el bloque del tema
            // y dejar solo AppNavigation()
            AppNavigation()
        }
    }
}