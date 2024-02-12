package com.jimd.notaspersonalescompose.views.update

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
class UpdateNotaViewModel @Inject constructor(
    private val repo:NotasRepositorio
):ViewModel() {


    fun updateNotaOnEvent(updateNotasEvent: UpdateNotasEvent){
        when(updateNotasEvent){
            is UpdateNotasEvent.mensajeChange -> {
                notasUpdated = notasUpdated.copy(
                    mensaje = updateNotasEvent.mensaje
                )
            }
            is UpdateNotasEvent.tituloChange -> {
                notasUpdated = notasUpdated.copy(
                    titulo = updateNotasEvent.titulo
                )
            }
            UpdateNotasEvent.update -> {
                updateNota()
            }
            is UpdateNotasEvent.updateDateChange -> {
                notasUpdated = notasUpdated.copy(
                    updated = Date()
                )
            }

            is UpdateNotasEvent.createDateChange -> {
                notasUpdated = notasUpdated.copy(
                    create = updateNotasEvent.create
                )
            }

            is UpdateNotasEvent.etiquetaIDChange -> {
                notasUpdated = notasUpdated.copy(
                    etiqueta = updateNotasEvent.etiquetaID
                )
            }
        }
    }
    var notasUpdated by mutableStateOf(UpdateNotaState())
    fun getNotaForID(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val notaUpdate = repo.getNotasForID(id)
            notasUpdated = notasUpdated.copy(
                id = notaUpdate.id,
                titulo = notaUpdate.titulo,
                mensaje = notaUpdate.mensaje,
                etiqueta = notaUpdate.etiqueta,
                create = notaUpdate.create,
                updated = notaUpdate.updated
            )
        }
    }

    fun updateNota(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateNota(
                NotasEntity(
                    id = notasUpdated.id,
                    titulo = notasUpdated.titulo,
                    mensaje = notasUpdated.mensaje,
                    etiqueta = notasUpdated.etiqueta,
                    create = notasUpdated.create,
                    updated = Date()
                )
            )
        }
    }

}