package com.jimd.notaspersonalescompose.views.update

import java.util.Date

sealed class UpdateNotasEvent {
    data class tituloChange(val titulo:String):UpdateNotasEvent()
    data class mensajeChange(val mensaje:String):UpdateNotasEvent()
    data class etiquetaIDChange(val etiquetaID:Int):UpdateNotasEvent()
    data class createDateChange(val create:Date):UpdateNotasEvent()
    data class updateDateChange(val updateDate: Date):UpdateNotasEvent()
    object update:UpdateNotasEvent()
}