package com.belajar.jettrivia.models

data class QuestionItem(
    val question:String,
    val category:String,
    val answer:String,
    val choices:List<String>
)
