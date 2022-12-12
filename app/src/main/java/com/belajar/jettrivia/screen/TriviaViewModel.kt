package com.belajar.jettrivia.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.jettrivia.data.DataOrException
import com.belajar.jettrivia.models.QuestionItem
import com.belajar.jettrivia.repositories.TriviaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor(private val repo:TriviaRepository):ViewModel() {

    val data:MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception>> = mutableStateOf(
        DataOrException(
            null,
            true,
            Exception("")
        )
            )

    init {
        getAllQuestion()
    }


    fun getAllQuestion() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repo.getAllData()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false

            }
        }
    }

}