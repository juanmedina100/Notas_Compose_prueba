package com.jimd.notaspersonalescompose.views.update

import java.util.Date

data class UpdateNotaState(
    val id:Int = 0,
    val titulo:String="",
    val mensaje:String="",
    val etiqueta:Int=0,
    val create:Date=Date(),
    val updated: Date = Date()
)
