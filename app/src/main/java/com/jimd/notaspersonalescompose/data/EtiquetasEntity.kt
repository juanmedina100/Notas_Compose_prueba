package com.jimd.notaspersonalescompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EtiquetasEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val etiqueta:String,
    val create:Date
)
