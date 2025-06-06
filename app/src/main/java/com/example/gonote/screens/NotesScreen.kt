package com.example.gonote.screens

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonote.Models.Notes
import com.example.gonote.ui.theme.Black
import com.example.gonote.ui.theme.Grey
import com.example.gonote.ui.theme.LightGrey

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


    Scaffold(floatingActionButton = {
        FloatingActionButton(contentColor = Color.White, containerColor = Color.Red,
            onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "ADD",
                modifier = Modifier.size(30.dp))
        }
    }) { innerPadding->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(color = Black)){
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Notes  ",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn {
                    items(notesList) {notes->
                        ListItem(notes)

                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ListItemPreview(){
    ListItem(notes = Notes(
        "first task",
        "wake up first and then don't touch the phone "))
}

@Composable
fun ListItem(notes: Notes) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        .background(color = Grey))
    {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu",
            tint = Color.White, modifier = Modifier.align(Alignment.TopEnd).padding(10.dp))
        
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = notes.title, color = Color.White,
                fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = notes.description, color = LightGrey)
        }
    }

}