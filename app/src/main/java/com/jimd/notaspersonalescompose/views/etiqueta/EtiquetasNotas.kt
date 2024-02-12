package com.jimd.notaspersonalescompose.views.etiqueta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun etiquetasNotas(navController: NavHostController,viewModel: EtiquetaViewModel= hiltViewModel()) {
    val etiqueta = viewModel.etiqueta
    Box(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp), contentAlignment = Alignment.TopCenter){
        Column(modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.Cyan)) {
            Text(text = "NUeva etiqueta")
            OutlinedTextField(value = etiqueta.etiqueta, onValueChange = {viewModel.etiquetaOnEvent(EtiquetaEvent.etiquetaChange(it))})
            Button(onClick = {
                viewModel.etiquetaOnEvent(EtiquetaEvent.guardar)
                navController.popBackStack()
            }) {
                Text(text = "Agregar")
            }
        }
    }
}