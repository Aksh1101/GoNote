package com.example.gonote.screens

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
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonote.ui.theme.Black
import com.example.gonote.ui.theme.Grey
import com.example.gonote.ui.theme.LightGrey

@Preview
@Composable
fun InsertNoteScreen(){
    Scaffold(floatingActionButton = {
        FloatingActionButton(contentColor = Color.White, containerColor = Color.Red,
            onClick = {})
        {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Done",
                modifier = Modifier.size(30.dp)
                )
        }
    }) { innerPadding->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(color = Black))
        {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Take a Note  ",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(label = {
                    Text(text = "Title", fontSize = 20.sp, color = LightGrey)
                }, shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Grey,
                        unfocusedContainerColor = Grey,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    )
                    )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(label = {
                    Text(text = "Description", fontSize = 20.sp, color = LightGrey)
                }, shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
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