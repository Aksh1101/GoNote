package com.example.gonote.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.example.gonote.Models.Notes
import com.example.gonote.Navigation.NotesNavigationItem
import com.example.gonote.ui.theme.Black
import com.example.gonote.ui.theme.Grey
import com.example.gonote.ui.theme.LightGrey
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun NotesScreen(navHostController: NavHostController){

    val database = FirebaseFirestore.getInstance()
    val notesDBRef = database.collection("Notes")

    val notesList = remember {
        mutableStateListOf<Notes>()
    }

    val dataValue = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        notesDBRef.addSnapshotListener { value , error->
            if (error == null){
                val data = value?.toObjects(Notes::class.java)
                notesList.clear()
                notesList.addAll(data!!)
                dataValue.value= true
            }
            else{
                dataValue.value= false
            }
        }
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(contentColor = Color.White, containerColor = Color.Red,
            onClick = {
                navHostController.navigate(NotesNavigationItem.InsertNoteScreen.route + "/defaultId")
            }) {
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

                if (dataValue.value){
                    LazyColumn {
                        items(notesList) {notes->
                            ListItem(notes , notesDBRef,navHostController)

                        }
                    }
                }
                else{
                    Box(modifier = Modifier.fillMaxSize()){
                        CircularProgressIndicator(modifier = Modifier.size(25.dp)
                            .align(Alignment.Center))
                    }
                }
            }
        }
    }
}


@Composable
fun ListItem(notes: Notes, notesDBRef: CollectionReference , navHostController : NavHostController) {

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        .background(color = Grey))
    {

        DropdownMenu(modifier = Modifier.background(Color.White),
            properties = PopupProperties(clippingEnabled = true),
            offset = _root_ide_package_.androidx.compose.ui.unit.DpOffset(x=(-40.dp),y=0.dp),
            expanded = expanded,
            onDismissRequest = {expanded = false}) {
            DropdownMenuItem(text = {Text(text = "Update", color = Color.Black, fontSize = 15.sp)},
                onClick = {
                    navHostController.navigate(NotesNavigationItem.InsertNoteScreen.route + "/${notes.id}")
                    expanded = false
                })
            DropdownMenuItem(text = {Text(text = "Delete", color = Color.Black, fontSize = 15.sp)},
                onClick = {
                    notes.id
                    notesDBRef.document(notes.id).delete()
                    expanded = false

                })
        }

        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu",
            tint = Color.White, modifier = Modifier.align(Alignment.TopEnd).padding(10.dp)
                .clickable{expanded = true})
        
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = notes.title, color = Color.White,
                fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = notes.description, color = LightGrey, fontSize = 15.sp)
        }
    }

}