package com.belajar.jettrivia.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp

@Composable
fun DotDivider (pathEffect: PathEffect) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp),
        onDraw = {
            drawLine(
                color = Color.LightGray,
                start = Offset(0F,0F),
                end = Offset(size.width,0F),
                pathEffect =pathEffect
            )
        } )
}