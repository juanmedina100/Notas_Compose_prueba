package com.jimd.notaspersonalescompose.views.home

sealed class HomeEvent {
    data class etiquetaSelected(val etiqueta:Int):HomeEvent()
    object itemSelected:HomeEvent()
}