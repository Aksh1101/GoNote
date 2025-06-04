package com.example.gonote.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonote.Models.Notes
import com.example.gonote.ui.theme.Black

@Preview
@Composable
fun NotesScreen(){

    val notesList = listOf(
        Notes(
            title = "First Task",
            description = "Drink Water"
        ),
        Notes(
            title = "Second Task",
            description = "Complete Kotlin Crash Course"
        ),

        Notes(
            title = "Third Task",
            description = "Revise Android Basics"
        ),

        Notes(
            title = "Fourth Task",
            description = "Apply for Internships"
        ),

        Notes(
            title = "Fifth Task",
            description = "Write a Blog on Medium"
        ),

        Notes(
            title = "Sixth Task",
            description = "Practice DSA from Kunal Kushwaha's Playlist"
        ),

        Notes(
            title = "Seventh Task",
            description = "Learn Linux Fundamentals"
        ),

        Notes(
            title = "Eighth Task",
            description = "Study Spring Boot for Backend Development"
        ),

        Notes(
            title = "Ninth Task",
            description = "Contribute to Open Source Projects"
        ),

        Notes(
            title = "Tenth Task",
            description = "Read about Financial Literacy and Forex"
        )
    )


    Scaffold { innerPadding->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(color = Black)){
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Take a Note ",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold)
            }
        }
        LazyColumn {
            items(notesList) {

            }
        }
    }
}