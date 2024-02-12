package com.jimd.notaspersonalescompose.views.etiqueta

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.domain.NotasRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class EtiquetaViewModel @Inject constructor(
    private val repo:NotasRepositorio
):ViewModel() {


    fun etiquetaOnEvent(etiquetaEvent: EtiquetaEvent){
        when(etiquetaEvent){
            is EtiquetaEvent.etiquetaChange -> {
                etiqueta = etiqueta.copy(
                    etiqueta = etiquetaEvent.etiqueta
                )
            }
            EtiquetaEvent.guardar -> {insertEtiqueta()}
            is EtiquetaEvent.etiquetaIDChange -> {
                etiqueta = etiqueta.copy(
                    id = etiquetaEvent.etiquetaID
                )
            }
        }
    }
    var etiqueta by mutableStateOf(EtiquetaState())

    fun insertEtiqueta(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertEtiquetas(
                EtiquetasEntity(
                    id = 0,
                    etiqueta = etiqueta.etiqueta,
                    create = Date()
                )
            )
        }
    }




    //Etiquetas
    //var myEtiqueta by mutableStateOf(EtiquetaState())
    fun getAllEtiquetas(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllEtiquetas().collect{
                if (it.isEmpty()){
                    repo.insertEtiquetas(
                        EtiquetasEntity(0,"General", Date())
                    )
                }
                etiqueta = etiqueta.copy(
                    listaEtiquetas = it
                )
            }
        }
    }
}