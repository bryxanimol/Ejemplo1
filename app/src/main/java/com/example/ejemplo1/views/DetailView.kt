package com.example.ejemplo1.views

import android.annotation.SuppressLint
import androidx.annotation.ContentView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ejemplo1.components.ActionButton
import com.example.ejemplo1.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleBar("Detail View")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(

                    containerColor = Color.Blue
                )
            )
        },
        floatingActionButton = {
            ActionButton(colores = Color.Blue)
        }
    )
    {
        ContentView()
    }

}
@Composable
private fun ContentView(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Detail")
    }

}