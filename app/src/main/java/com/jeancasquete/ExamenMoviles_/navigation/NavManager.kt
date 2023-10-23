package com.jeancasquete.ExamenMoviles_.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jeancasquete.ExamenMoviles_.viewmodels.MascotasViewModel
import com.jeancasquete.ExamenMoviles_.views.AgregarView
import com.jeancasquete.ExamenMoviles_.views.EditarView
import com.jeancasquete.ExamenMoviles_.views.InicioView

@Composable
fun NavManager(viewModel: MascotasViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "agregar") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{nombre}/{raza}/{color}/{edad}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("nombre") { type = NavType.StringType },
            navArgument("raza") { type = NavType.StringType },
            navArgument("color") { type = NavType.StringType },
            navArgument("edad"){ type = NavType.StringType },



        )) {
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre"),
                it.arguments?.getString("raza"),
                it.arguments?.getString("color"),
                it.arguments?.getString("edad"),



                )
        }
    }

}