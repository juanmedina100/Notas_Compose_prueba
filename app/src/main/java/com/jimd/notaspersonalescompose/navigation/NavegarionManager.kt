package com.jimd.notaspersonalescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jimd.notaspersonalescompose.views.add.addNotas
import com.jimd.notaspersonalescompose.views.etiqueta.etiquetasNotas
import com.jimd.notaspersonalescompose.views.home.notasHome
import com.jimd.notaspersonalescompose.views.update.updateNotas

@Composable
fun navegationManager(navController: NavHostController){

    NavHost(navController = navController, startDestination = Routes.main.route){
        composable(Routes.main.route){ notasHome(navController) }
        composable(Routes.add.route){ addNotas(navController) }
        composable(Routes.update.route+"/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                }
            )
            ){
            updateNotas(navController,id=it.arguments?.getString("id").orEmpty()) }
        composable(Routes.newEtiqueta.route){ etiquetasNotas(navController) }
    }
}