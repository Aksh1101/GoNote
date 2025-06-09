package com.example.gonote.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gonote.screens.InsertNoteScreen
import com.example.gonote.screens.NotesScreen
import com.example.gonote.screens.SplashScreen

@Composable
fun NotesNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "splash"){
        composable(route = NotesNavigationItem.SplashScreen.route) {
            SplashScreen(navHostController)
        }
        composable(route = NotesNavigationItem.HomeScreen.route) {
            NotesScreen(navHostController)
        }
        composable(route = NotesNavigationItem.InsertNoteScreen.route + "/{id}") {
            val id = it.arguments?.getString("id")
            InsertNoteScreen(navHostController , id)
        }
    }
}