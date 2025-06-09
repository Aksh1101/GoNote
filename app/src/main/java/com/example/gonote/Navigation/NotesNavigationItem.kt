package com.example.gonote.Navigation

sealed class NotesNavigationItem(val route : String) {

    object SplashScreen: NotesNavigationItem(route = "splash")
    object HomeScreen: NotesNavigationItem(route = "home")
    object InsertNoteScreen: NotesNavigationItem(route = "insert_note_screen")

}