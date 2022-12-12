package com.belajar.jettrivia.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.jettrivia.models.QuestionItem

@Composable
fun TheQuestion(
    question:QuestionItem,
    currentQuestion: MutableState<Int>,
    onNext:(Int) -> Unit
) {
    val listChoice = remember(question) {
        question.choices.toMutableList()
    }

    val answerState = remember {
        mutableStateOf<Int?>(null)
    }

    val correctAnswer = remember {
        mutableStateOf<Boolean?>(null)
    }

    val score = remember {
        mutableStateOf(0)
    }


    val updateAnswer:(Int) -> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswer.value = listChoice[it] == question.answer
            if (correctAnswer.value == true) {
                score.value = score.value +1
            }
        }
    }

    Spacer(modifier = Modifier.height(12.dp))

  Text(text = question.question,
        lineHeight = 22.sp,
        fontSize = 14.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxHeight(0.3F))

    listChoice.forEachIndexed { index, item ->
        Surface(
            Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp)),
            color = Color.Transparent,


            ) {
            Row (
                Modifier.padding(5.dp),
                verticalAlignment = CenterVertically
            ) {

                RadioButton(selected = (answerState.value == index),
                    onClick = {
                        updateAnswer.invoke(index)
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor =
                        if (correctAnswer.value == true
                            && index == answerState.value)
                            Color.Green
                        else Color.Red,
                        unselectedColor = Color.White
                    ))
                Spacer(modifier = Modifier.width(14.dp))
                Text(text = item,
                    fontSize = 14.sp,
                    color = Color.White)


            }

        }

        Spacer(modifier = Modifier.height(12.dp))
    }



    ButtonNext(currentQuestion = currentQuestion ,
        onNext = {
            answerState.value = null
            onNext.invoke(score.value)

        } )
}

