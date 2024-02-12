package com.jimd.notaspersonalescompose.views.add

import java.util.Date

data class AddNotasState (
    val id:Int = 0,
    val titulo:String="",
    val mensaje:String="",
    val etiqueta:Int=0,
    val create: Date=Date(),
    val updated: Date=Date()
)