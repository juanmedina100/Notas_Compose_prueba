package com.jimd.notaspersonalescompose.views.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.notaspersonalescompose.data.NotasEntity
import com.jimd.notaspersonalescompose.domain.NotasRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddNotaViewModel @Inject constructor(
    private val repo:NotasRepositorio
): ViewModel() {

    fun addNotasEvent(addNotasEvent: AddNotasEvent){
        when(addNotasEvent){
            is AddNotasEvent.createChange -> {
                addNota = addNota.copy(
                    create = Date()
                )
            }
            AddNotasEvent.guardarNota -> {
                insertnota()
            }
            is AddNotasEvent.notaChange -> {
                addNota = addNota.copy(
                    mensaje = addNotasEvent.nota
                )
            }
            is AddNotasEvent.tituloChange -> {
                addNota = addNota.copy(
                    titulo = addNotasEvent.titulo
                )
            }
            is AddNotasEvent.updateChange -> {
                addNota = addNota.copy(
                    updated = Date()
                )
            }
            is AddNotasEvent.etiquetaID -> {
                addNota = addNota.copy(
                    etiqueta = addNotasEvent.etiqueta
                )
            }
        }
    }

    var addNota by mutableStateOf(AddNotasState())
    fun insertnota(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertNota(
                NotasEntity(id=0,
                    titulo = addNota.titulo,
                    mensaje = addNota.mensaje,
                    etiqueta = addNota.etiqueta,
                    create = addNota.create,
                    updated = addNota.updated)
            )
        }
    }

}