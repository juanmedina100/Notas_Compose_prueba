package com.jimd.notaspersonalescompose.views.etiqueta

sealed class EtiquetaEvent {
    data class etiquetaIDChange(val etiquetaID:Int):EtiquetaEvent()
    data class etiquetaChange(val etiqueta:String):EtiquetaEvent()
    object guardar:EtiquetaEvent()
}