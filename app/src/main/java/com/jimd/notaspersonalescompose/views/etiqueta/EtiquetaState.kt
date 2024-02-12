package com.jimd.notaspersonalescompose.views.etiqueta

import com.jimd.notaspersonalescompose.data.EtiquetasEntity

data class EtiquetaState (
    val id:Int=0,
    val etiqueta:String="",
    val listaEtiquetas:List<EtiquetasEntity> = emptyList()
)