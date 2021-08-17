package com.plygrnd.andr.cmpse.jetpackcomposelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plygrnd.andr.cmpse.jetpackcomposelayout.sample.list.ScrollingList
import com.plygrnd.andr.cmpse.jetpackcomposelayout.ui.theme.JetpackComposeLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLayoutTheme {
//                PhotographerCard()
//                LayoutsCodelab()
//                SimpleList()
//                LazyList()
//                ImageList()
                ScrollingList()
            }
        }
    }
}