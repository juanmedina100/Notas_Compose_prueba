package com.jimd.notaspersonalescompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {

    @Query("select * from notasentity order by id asc")
    fun getAllNotas(): Flow<List<NotasEntity>>

    @Insert
    suspend fun insertNota(notasEntity: NotasEntity)

    @Update
    suspend fun updateNota(notasEntity: NotasEntity)

    @Delete
    suspend fun deleteNota(notasEntity: NotasEntity)

    @Query("select * from notasentity where id=:id")
    suspend fun getNotasForID(id:Int):NotasEntity

    //Etiquetas
    @Query("select * from etiquetasentity order by id")
    fun getAllEtiquetas():Flow<List<EtiquetasEntity>>

    @Insert
    suspend fun insertEtiquetas(etiquetasEntity: EtiquetasEntity)

    @Query("select * from notasentity where etiqueta=:id")
    fun getAllNotasForIDOfEtiqueta(id:Int):Flow<List<NotasEntity>>

}