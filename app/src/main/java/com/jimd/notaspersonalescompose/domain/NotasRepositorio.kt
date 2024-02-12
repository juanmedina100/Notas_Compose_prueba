package com.jimd.notaspersonalescompose.domain

import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.data.NotasEntity
import kotlinx.coroutines.flow.Flow

interface NotasRepositorio {


    fun getAllNotas(): Flow<List<NotasEntity>>

    suspend fun insertNota(notasEntity: NotasEntity)

    suspend fun updateNota(notasEntity: NotasEntity)

    suspend fun deleteNota(notasEntity: NotasEntity)

    suspend fun getNotasForID(id:Int):NotasEntity

    fun getAllEtiquetas():Flow<List<EtiquetasEntity>>

    suspend fun insertEtiquetas(etiquetasEntity: EtiquetasEntity)

    fun getAllNotasForIDOfEtiqueta(id:Int):Flow<List<NotasEntity>>
}