package com.example.huertohogar.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.huertohogar.R
import com.example.huertohogar.ui.components.BotonHuerto
import com.example.huertohogar.ui.components.CampoTexto
import com.example.huertohogar.ui.theme.GreenHuerto
import com.example.huertohogar.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginViewModel = viewModel()
    val scope = rememberCoroutineScope()

    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo o Título
        Text(
            text = "🥑 HuertoHogar",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = GreenHuerto
        )

        Spacer(modifier = Modifier.height(32.dp))

        CampoTexto(
            valor = correo,
            onValorCambio = { correo = it },
            etiqueta = "Correo (@duocuc.cl)"
        )

        Spacer(modifier = Modifier.height(16.dp))

        CampoTexto(
            valor = password,
            onValorCambio = { password = it },
            etiqueta = "Contraseña",
            visualTransformation = PasswordVisualTransformation()
        )

        if (mensajeError.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensajeError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(24.dp))

        BotonHuerto(texto = "Iniciar Sesión") {
            scope.launch {
                val exito = viewModel.login(correo, password)
                if (exito) {
                    navController.navigate("catalogo") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    mensajeError = "Credenciales inválidas o correo no permitido"
                }
            }
        }
    }
}