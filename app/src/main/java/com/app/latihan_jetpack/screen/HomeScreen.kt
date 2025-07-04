package com.app.latihan_jetpack.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.latihan_jetpack.component.NoteCard
import com.app.latihan_jetpack.model.viewModel.NotesViewModel
import com.app.latihan_jetpack.navigation.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: NotesViewModel = viewModel()
) {
    val notesState by viewModel.notes.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 24.dp)
    ){
        if(notesState.isEmpty()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }else{
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ){
                items(notesState){
                    note ->
                    NoteCard(note)
                }
            }
        }
    }

}
    @Preview(showBackground = true)
    @Composable
    fun HomeScreenView() {
        HomeScreen(
            navController = rememberNavController()
        )
    }