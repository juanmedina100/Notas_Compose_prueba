package com.jimd.notaspersonalescompose.views.home

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.data.NotasEntity
import com.jimd.notaspersonalescompose.navigation.Routes
import com.jimd.notaspersonalescompose.views.componentes.topAppBarMain

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun notasHome(navController: NavHostController) {
    Scaffold(
        topBar = {
            topAppBarMain()
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.add.route)
            }) {
                Icon(Icons.Default.Add, contentDescription = "add")
            }
        }
    ) {
        contenidoHome(paddingValues = it, navController = navController)
    }
}
@Composable
fun contenidoHome(paddingValues: PaddingValues, navController: NavHostController,viewModel: HomeViewModel= hiltViewModel()){
    LaunchedEffect(key1 = Unit){
        viewModel.getAllNotas()
        viewModel.getAllEtiquetas()
    }
    val notas = viewModel.mynotas.notas
    val etiqueta = viewModel.myEtiqueta.etiquetas
    Box(modifier= Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(8.dp)){
        Column(modifier= Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Row(modifier=Modifier.fillMaxWidth()){
                LazyRow(modifier=Modifier.padding(3.dp)){
                    items(etiqueta) {
                        etiquetasRow(it,viewModel)
                    }
                }
                etiquetasAddEtiqueta(navController)
            }
            LazyColumn{
                items(notas) {
                    itemsHome(
                        navController = navController,
                        notasEntity = it,
                        viewModel =  viewModel)
                }
            }
        }
    }
}
@Composable
fun itemsHome(navController: NavHostController, notasEntity: NotasEntity,viewModel: HomeViewModel){
    Card(modifier= Modifier
        .fillMaxWidth()
        .padding(5.dp), colors = CardDefaults.cardColors(Color.White), elevation = CardDefaults.cardElevation(4.dp)) {
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier= Modifier
                .fillMaxWidth()
                .weight(1f)) {
                Text(text = notasEntity.titulo,modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Text(text = notasEntity.mensaje,modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp), maxLines = 3)
                Text(text = notasEntity.create.toString(),modifier= Modifier
                    .fillMaxWidth()
                    .padding(10.dp), textAlign = TextAlign.End, fontStyle = FontStyle.Italic)
            }
            Column(modifier= Modifier
                .width(30.dp)) {
                IconButton(onClick = { navController.navigate(Routes.update.route+"/${Uri.encode(notasEntity.id.toString())}") }) {
                    Icon(Icons.Rounded.Edit,"editar")
                }
                IconButton(onClick = { viewModel.deleteNota(notasEntity) }) {
                    Icon(Icons.Rounded.Delete,"eliminar")
                }
            }
        }

    }
}

@Composable
fun etiquetasRow(etiquetasEntity: EtiquetasEntity, viewModel: HomeViewModel){
    if (viewModel.myEtiqueta.selected){
        Card(modifier= Modifier
            .padding(5.dp)
            .clickable {
                viewModel.onEvent(HomeEvent.itemSelected)
                viewModel.onEvent(HomeEvent.etiquetaSelected(etiquetasEntity.id))
                viewModel.getAllNotasForIDOfEtiqueta(etiquetasEntity.id)
                Log.i("MIMIMI","${viewModel.myEtiqueta}")
            }) {//, colors = CardDefaults.cardColors(Color.Cyan)
            Text(text = etiquetasEntity.etiqueta,modifier=Modifier.padding(20.dp))
        }
    }else{
        Card(modifier= Modifier
            .padding(5.dp)
            .clickable {
                viewModel.onEvent(HomeEvent.itemSelected)
                viewModel.onEvent(HomeEvent.etiquetaSelected(etiquetasEntity.id))
                viewModel.getAllNotasForIDOfEtiqueta(etiquetasEntity.id)
            }) {
            Text(text = etiquetasEntity.etiqueta,modifier=Modifier.padding(20.dp))
        }
    }
}

@Composable
fun etiquetasAddEtiqueta(navController: NavHostController) {
    Card(modifier= Modifier
        .padding(5.dp)
        .clickable {
            navController.navigate(Routes.newEtiqueta.route)
        }) {
        Column(modifier=Modifier.padding(15.dp)) {
            Icon(Icons.Rounded.Add, contentDescription = "Agregar etiqueta")
        }
    }
}