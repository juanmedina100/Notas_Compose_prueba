package com.jimd.notaspersonalescompose.views.add

import java.util.Date

sealed class AddNotasEvent {
    data class tituloChange(val titulo:String):AddNotasEvent()
    data class notaChange(val nota:String):AddNotasEvent()
    data class etiquetaID(val etiqueta:Int):AddNotasEvent()
    data class createChange(val createdate: Date):AddNotasEvent()
    data class updateChange(val updatedate: Date):AddNotasEvent()
    object guardarNota:AddNotasEvent()
}