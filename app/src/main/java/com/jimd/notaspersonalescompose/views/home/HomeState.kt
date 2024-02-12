package com.jimd.notaspersonalescompose.views.home

import com.jimd.notaspersonalescompose.data.NotasEntity
import java.util.Date

data class HomeState(
    val id:Int = 0,
    val titulo:String="",
    val mensaje:String="",
    val etiqueta:Int=0,
    val create: Date = Date(),
    val updated: Date = Date(),
    val notas:List<NotasEntity> = emptyList()
)
