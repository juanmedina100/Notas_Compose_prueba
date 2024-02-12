package com.jimd.notaspersonalescompose.views.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBarMain() {
    TopAppBar(title = { Text(text = "Mis notas",modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBarAdd(titulo:String,onBack:()->Unit) {
    TopAppBar(title = {
        Text(
            text = titulo,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }, navigationIcon = {
        IconButton(onClick = { onBack() }) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = "Regresar")
        }
    })
}
@Preview(showSystemUi = true)
@Composable
fun mutras(){
    var muestraEvento by remember{
        mutableStateOf(false)
    }
    val lista = listOf<EtiquetasEntity>(
        EtiquetasEntity(1,"Programación", Date()),
        EtiquetasEntity(2,"General", Date()),
        EtiquetasEntity(3,"Diseño", Date()),
        EtiquetasEntity(4,"Ropa", Date()),
        EtiquetasEntity(5,"Camarones", Date()),
        EtiquetasEntity(6,"Barba", Date()),
    )
    Column(modifier=Modifier.fillMaxWidth()) {
        LazyRow{
            items(lista){
                Card(modifier=Modifier.padding(2.dp).clickable {  }) {
                    Text(text = it.etiqueta,modifier=Modifier.padding(10.dp))
                }
            }
        }
    }
}