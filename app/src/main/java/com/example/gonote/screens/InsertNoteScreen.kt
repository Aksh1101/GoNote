package com.example.gonote.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gonote.Models.Notes
import com.example.gonote.ui.theme.Black
import com.example.gonote.ui.theme.Grey
import com.example.gonote.ui.theme.LightGrey
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun InsertNoteScreen(navHostController: NavHostController, id: String?) {

    val context = LocalContext.current
    val database = FirebaseFirestore.getInstance()
    val notesDBRef = database.collection("Notes")

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        if (id != "defaultId"){
            notesDBRef.document(id.toString()).get().addOnSuccessListener {
                val singleData = it.toObject(Notes::class.java)
                title.value = singleData!!.title
                description.value = singleData.description
            }
        }
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(contentColor = Color.White, containerColor = Color.Red,
            onClick = {
                if (title.value.isEmpty() && description.value.isEmpty()){
                    Toast.makeText(context, "Enter valid data", Toast.LENGTH_SHORT).show()
                }
                else{

                    var myNotesId =""

                    myNotesId = if (id != "defaultId") {
                        id.toString()
                    } else {
                        notesDBRef.document().id
                    }

                    val notes = Notes(
                        id = myNotesId,
                        title = title.value,
                        description = description.value
                    )

                    notesDBRef.document(myNotesId).set(notes).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(context, "Noted Successfully", Toast.LENGTH_SHORT).show()
                            navHostController.popBackStack()
                        }
                        else{
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Done",
                modifier = Modifier.size(30.dp)
                )
        }
    }) { innerPadding->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Black))
        {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Take a Note  ",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(textStyle = TextStyle(color = Color.White,fontSize = 25.sp),label = {
                    Text(text = "Title", fontSize = 20.sp, color = LightGrey)
                }, shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    value = title.value,
                    onValueChange = {title.value=it},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Grey,
                        unfocusedContainerColor = Grey,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    )
                    )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(textStyle = TextStyle(color = Color.White, fontSize = 20.sp),label = {
                    Text(text = "Description", fontSize = 20.sp, color = LightGrey)
                }, shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    value = description.value,
                    onValueChange = {description.value=it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Grey,
                        unfocusedContainerColor = Grey,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    )
                )


            }

        }
    }
}