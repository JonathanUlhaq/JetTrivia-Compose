package com.belajar.jettrivia.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import com.belajar.jettrivia.components.*


@Composable
fun Testing(viewModel:TriviaViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20F,10F),10F)

    val sizeQuestion = questions?.size

    val score = remember {
        mutableStateOf(0)
    }

    val correct = remember {
        mutableStateOf(false)
    }

    val currentQuestion = remember {
        mutableStateOf(0)
    }

    val question = try {
        questions?.get(currentQuestion.value)
    } catch (e:Exception) {
        null
    }

    Log.d("CORRECT NI BOS", "${correct.value}")

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color.Black
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(14.dp)
        ) {

            ProgressBar(score.value)
            Spacer(modifier = Modifier.height(14.dp))
            if (sizeQuestion != null) {
                QuestHeader(question = currentQuestion.value+1, allQuestion = sizeQuestion)
            }
            Spacer(modifier = Modifier.height(14.dp))
            DotDivider(pathEffect = pathEffect)
            if (questions != null) {
                TheQuestion(question!!,
                    currentQuestion = currentQuestion,

                    onNext = {
                        currentQuestion.value = currentQuestion.value + 1
                        score.value = it
                    })
            }
        }
    }

}