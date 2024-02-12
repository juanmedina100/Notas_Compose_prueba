package com.jimd.notaspersonalescompose.data.repositorio

import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import com.jimd.notaspersonalescompose.data.NotasDao
import com.jimd.notaspersonalescompose.data.NotasEntity
import com.jimd.notaspersonalescompose.domain.NotasRepositorio
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotasRepositorioImpl @Inject constructor(
    private val dao: NotasDao
) :NotasRepositorio {
    override fun getAllNotas()=dao.getAllNotas()

    override suspend fun insertNota(notasEntity: NotasEntity) {
        dao.insertNota(notasEntity)
    }

    override suspend fun updateNota(notasEntity: NotasEntity) {
        dao.updateNota(notasEntity)
    }

    override suspend fun deleteNota(notasEntity: NotasEntity) {
        dao.deleteNota(notasEntity)
    }

    override suspend fun getNotasForID(id: Int): NotasEntity {
          return dao.getNotasForID(id)
    }

    override fun getAllEtiquetas()=dao.getAllEtiquetas()

    override suspend fun insertEtiquetas(etiquetasEntity: EtiquetasEntity) {
        dao.insertEtiquetas(etiquetasEntity)
    }

    override fun getAllNotasForIDOfEtiqueta(id: Int)=dao.getAllNotasForIDOfEtiqueta(id)
}