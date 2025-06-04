package com.example.gonote.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonote.ui.theme.Black
import com.example.gonote.R

@Preview
@Composable
fun SplashScreen(){
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(color = Black))
        {
            Image(painterResource(R.drawable.gonote_logo_design),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)
                    .align(Alignment.Center))

        }
    }

}
