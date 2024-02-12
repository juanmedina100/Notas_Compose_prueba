package com.jimd.notaspersonalescompose.views.update

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.views.add.AddNotaViewModel
import com.jimd.notaspersonalescompose.views.add.AddNotasEvent
import com.jimd.notaspersonalescompose.views.add.contenAdd
import com.jimd.notaspersonalescompose.views.add.etiquetasRowAdd
import com.jimd.notaspersonalescompose.views.componentes.topAppBarAdd
import com.jimd.notaspersonalescompose.views.etiqueta.EtiquetaViewModel

@Composable
fun updateNotas(navController: NavHostController,id:String){
    Scaffold(
        topBar = { topAppBarAdd(titulo = "Actualizar Nota",onBack = { navController.popBackStack() }) }
    ) {
        contenUpdate(paddingValues = it, navController = navController,id)
    }
}

@Composable
fun contenUpdate(paddingValues: PaddingValues, navController: NavHostController,id:String,viewModel: UpdateNotaViewModel= hiltViewModel(),viewModelEtiqueta:EtiquetaViewModel= hiltViewModel()) {
    val idUri = Uri.decode(id).toInt()
    LaunchedEffect(key1 = Unit){
        viewModel.getNotaForID(idUri)
        viewModelEtiqueta.getAllEtiquetas()
    }
    val notasUpdate = viewModel.notasUpdated
    val etiqueta = viewModelEtiqueta.etiqueta.listaEtiquetas
    Box(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()
        .padding(16.dp), contentAlignment = Alignment.TopCenter){
        Column(modifier=Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(value = notasUpdate.titulo, onValueChange = {
                 viewModel.updateNotaOnEvent(UpdateNotasEvent.tituloChange(it))
            },modifier=Modifier.fillMaxWidth(), placeholder = { Text(
                text = "Titulo"
            ) }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.White, unfocusedBorderColor = Color.White))

            LazyRow(modifier=Modifier.padding(3.dp)){
                items(etiqueta) {
                    etiquetasRowUpdate(it,viewModel)
                }
            }


            OutlinedTextField(value = notasUpdate.mensaje, onValueChange = {
                viewModel.updateNotaOnEvent(UpdateNotasEvent.mensajeChange(it))
            },modifier=Modifier.fillMaxWidth(), placeholder = { Text(
                text = "Mensaje"
            ) }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.White, unfocusedBorderColor = Color.White))
            Button(onClick = {
                viewModel.updateNotaOnEvent(UpdateNotasEvent.update)
                navController.popBackStack()
            }) {
                Text(text = "Actualizar")
            }
        }
    }
}
@Composable
fun etiquetasRowUpdate(etiquetasEntity: EtiquetasEntity, viewModel: UpdateNotaViewModel){
    Card(modifier= Modifier
        .padding(1.dp)
        .clickable {
            viewModel.updateNotaOnEvent(UpdateNotasEvent.etiquetaIDChange(etiquetasEntity.id))
            Log.i("MIMIMI","${etiquetasEntity.id}")
        }) {
        Text(text = etiquetasEntity.etiqueta,modifier=Modifier.padding(20.dp))
    }
}