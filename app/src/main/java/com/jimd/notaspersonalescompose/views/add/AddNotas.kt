package com.jimd.notaspersonalescompose.views.add

import android.util.Log
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.views.componentes.topAppBarAdd
import com.jimd.notaspersonalescompose.views.etiqueta.EtiquetaEvent
import com.jimd.notaspersonalescompose.views.etiqueta.EtiquetaViewModel
import com.jimd.notaspersonalescompose.views.home.etiquetasRow

@Composable
fun addNotas(navController: NavHostController) {
    Scaffold(
        topBar = { topAppBarAdd(titulo = "Agregar Nota",onBack = { navController.popBackStack() }) }
    ) {
        contenAdd(paddingValues = it, navController = navController)
    }

}

@Composable
fun contenAdd(paddingValues: PaddingValues, navController: NavHostController, viewModel: AddNotaViewModel= hiltViewModel(), viewModelEtiqueta:EtiquetaViewModel= hiltViewModel()){
    LaunchedEffect(key1 = Unit){
        viewModelEtiqueta.getAllEtiquetas()
    }
    val nota = viewModel.addNota
    val etiqueta = viewModelEtiqueta.etiqueta.listaEtiquetas
    Box(modifier = Modifier
        .fillMaxSize().padding(paddingValues)
        .padding(16.dp), contentAlignment = Alignment.TopCenter){
        Column(modifier=Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Agregar nota",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            LazyRow(modifier=Modifier.padding(3.dp)){
                items(etiqueta) {
                    etiquetasRowAdd(it,onClicked = { viewModel.addNotasEvent(AddNotasEvent.etiquetaID(it)) })
                }
            }
            OutlinedTextField(value = nota.titulo, onValueChange = {viewModel.addNotasEvent(AddNotasEvent.tituloChange(it))},modifier=Modifier.fillMaxWidth(), placeholder = { Text(
                text = "Titulo"
            ) }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.White, unfocusedBorderColor = Color.White))
            OutlinedTextField(value = nota.mensaje, onValueChange = {viewModel.addNotasEvent(AddNotasEvent.notaChange(it))},modifier=Modifier.fillMaxWidth(), placeholder = { Text(
                text = "Mensaje"
            ) }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.White, unfocusedBorderColor = Color.White))
            Button(onClick = {
                viewModel.addNotasEvent(AddNotasEvent.guardarNota)
                navController.popBackStack()
            }) {
                Text(text = "Agregar")
            }
        }
    }
}
@Composable
fun etiquetasRowAdd(etiquetasEntity: EtiquetasEntity, onClicked:(Int)->Unit){
    Card(modifier= Modifier
        .padding(1.dp)
        .clickable {
            onClicked(etiquetasEntity.id)
            //viewModel.addNotasEvent(AddNotasEvent.etiquetaID(etiquetasEntity.id))
        }.testTag("card_etiquetaRowAdd")) {
        Text(text = etiquetasEntity.etiqueta,modifier=Modifier.padding(20.dp).testTag("card_etiquetaRowAdd_text"))
    }
}

@Composable
fun etiquetaInteligente(){
    Card(modifier= Modifier
        .padding(1.dp)
        .clickable {

        }.testTag("cardTest")) {
        Text(text = "JIMD",modifier=Modifier.padding(20.dp).testTag("jimd"))
    }
}