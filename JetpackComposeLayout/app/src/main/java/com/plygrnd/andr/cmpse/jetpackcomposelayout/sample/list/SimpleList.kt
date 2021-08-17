package com.plygrnd.andr.cmpse.jetpackcomposelayout.sample.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plygrnd.andr.cmpse.jetpackcomposelayout.ui.theme.JetpackComposeLayoutTheme

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item #$it")
        }
    }
}

@Preview
@Composable
fun SimpleListPreview() {
    JetpackComposeLayoutTheme {
        SimpleList()
    }
}