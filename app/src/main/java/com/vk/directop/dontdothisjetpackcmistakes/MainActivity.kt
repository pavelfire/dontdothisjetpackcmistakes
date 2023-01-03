package com.vk.directop.dontdothisjetpackcmistakes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vk.directop.dontdothisjetpackcmistakes.ui.theme.DontDoThisJetPackCMistakesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var todos by remember {
                mutableStateOf(todos)
            }
            LazyColumn {
                item {
                    Text(text = "DONE")
                }
                items(todos.filter { it.isDone}) {
                    Text(text = it.title)
                }
                
                item { 
                    Text(text = "UNDONE")
                }
                items(todos.filter { !it.isDone}) {
                    Text(text = it.title)
                }
            }
        }
    }
}

data class Todo(
    val title: String,
    val isDone: Boolean
)

var todos = listOf<Todo>(
    Todo("Bring out the trash", false),
    Todo("Feed the cat", true),
    Todo("Cook dinner", true),
    Todo("Learn JetPack Compose", false),
    Todo("Meet girl from Tinder", false),
    Todo("Find Adroid Developer work", false),

)

