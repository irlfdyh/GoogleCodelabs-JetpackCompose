package com.plygrnd.andr.cmpse.jetpackcomposelayout.sample.customlayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plygrnd.andr.cmpse.jetpackcomposelayout.ui.theme.JetpackComposeLayoutTheme

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->

        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measureable ->
            // Measure each child
            measureable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }

    }
}

@Composable
fun BodyContent2(modifier: Modifier = Modifier) {
    MyOwnColumn(modifier = modifier.padding(8.dp)) {
        Text(text = "MyOwnColumn")
        Text(text = "places items")
        Text(text = "vertically.")
        Text(text = "We've done it by hand!")
    }
}

@Preview
@Composable
fun BodyContent2Preview() {
    JetpackComposeLayoutTheme {
        BodyContent2()
    }
}