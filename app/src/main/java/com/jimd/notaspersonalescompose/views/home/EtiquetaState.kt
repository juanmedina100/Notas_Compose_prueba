package com.jimd.notaspersonalescompose.views.home

import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import java.util.Date

data class EtiquetaState(
    val id:Int=0,
    val etiqueta:String="",
    val etiquetas:List<EtiquetasEntity> = emptyList(),
    val selected:Boolean=false
)
