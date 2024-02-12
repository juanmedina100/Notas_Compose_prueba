package com.jimd.notaspersonalescompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class NotasEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val titulo:String,
    val mensaje:String,
    val etiqueta:Int,
    val create:Date,
    val updated:Date
)