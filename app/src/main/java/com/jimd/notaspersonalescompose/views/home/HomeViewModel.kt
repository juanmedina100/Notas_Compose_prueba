package com.jimd.notaspersonalescompose.views.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.data.NotasEntity
import com.jimd.notaspersonalescompose.domain.NotasRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo:NotasRepositorio
): ViewModel() {

    fun onEvent(homeEvent: HomeEvent){
        when(homeEvent){
            is HomeEvent.etiquetaSelected -> {
                mynotas = mynotas.copy(
                    etiqueta = homeEvent.etiqueta
                )
            }
            is HomeEvent.itemSelected -> {
                myEtiqueta = myEtiqueta.copy(
                    selected = !myEtiqueta.selected
                )
                Log.i("MIMIMI","${myEtiqueta.selected}")
            }
        }
    }

    var myEtiqueta by mutableStateOf(EtiquetaState())
    var mynotas by mutableStateOf(HomeState())
    fun getAllNotas(){
        viewModelScope.launch {
            repo.getAllNotas().collect{
                mynotas = mynotas.copy(
                    notas = it
                )
            }
        }
    }

    //Eliminar nota
    fun deleteNota(notasEntity: NotasEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteNota(notasEntity)
        }
    }
    //Etiquetas
    fun getAllEtiquetas(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllEtiquetas().collect{
                if (it.isEmpty()){
                    repo.insertEtiquetas(
                        EtiquetasEntity(0,"General", Date())
                    )
                }
                myEtiqueta = myEtiqueta.copy(
                    etiquetas = it
                )
            }
        }
    }

    fun getAllNotasForIDOfEtiqueta(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotasForIDOfEtiqueta(id).collect{
                val notasForIDEtiqueta = it
                mynotas = mynotas.copy(
                    notas = it
                )
            }
        }
    }

}