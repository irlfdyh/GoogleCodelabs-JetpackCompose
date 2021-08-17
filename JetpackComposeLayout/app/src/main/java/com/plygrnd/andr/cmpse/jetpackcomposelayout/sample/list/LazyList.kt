package com.plygrnd.andr.cmpse.jetpackcomposelayout.sample.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.plygrnd.andr.cmpse.jetpackcomposelayout.ui.theme.JetpackComposeLayoutTheme

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text(text = "Item #$it")
        }
    }
}

@Preview
@Composable
fun LazyListPreview() {
    JetpackComposeLayoutTheme {
        LazyList()
    }
}