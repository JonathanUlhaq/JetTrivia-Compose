package com.belajar.jettrivia.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressBar(
    score:Int
) {

    val floatingScore = remember(score) {
        mutableStateOf(score * 0.01f)
    }

    val gradient = Brush.linearGradient(listOf(
        Color(0XFFF95075),
        Color(0XFFBE6BE5)
    ))

    Row(

        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    listOf(
                        Color.LightGray,
                        Color.LightGray
                    )
                ),
                shape = RoundedCornerShape(12.dp),
            )

    ) {
        Button(
            contentPadding = PaddingValues(1.dp),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(floatingScore.value)
                .background(brush = gradient),
            enabled = false,
            colors = buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent
            )) {
                if (score > 0)
                    Text(text = "$score",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 3.dp))
        }
    }
}