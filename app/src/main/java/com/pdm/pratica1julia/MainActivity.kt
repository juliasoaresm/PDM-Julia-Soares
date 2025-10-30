package com.pdm.pratica1julia

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm.pratica1julia.ui.theme.Pratica1JuliaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pratica1JuliaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun HomePage(modifier: Modifier = Modifier) {
    // 🧩 Pegamos o contexto e transformamos em Activity
    val activity = (LocalContext.current as? Activity)

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-vindo/a!",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = { activity?.finish() }, // ✅ Agora funciona
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "SAIR")
        }
    }
}
