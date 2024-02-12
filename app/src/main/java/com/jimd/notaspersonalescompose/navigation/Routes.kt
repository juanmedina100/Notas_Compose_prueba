package com.jimd.notaspersonalescompose.navigation

sealed class Routes(val route:String) {
    object main:Routes("main")
    object add:Routes("add")
    object update:Routes("update/{id}")
    object newEtiqueta:Routes("etiqueta")
}