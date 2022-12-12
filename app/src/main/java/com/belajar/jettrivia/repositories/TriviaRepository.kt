package com.belajar.jettrivia.repositories

import android.util.Log
import com.belajar.jettrivia.data.DataOrException
import com.belajar.jettrivia.models.QuestionItem
import com.belajar.jettrivia.network.TriviaAPI
import javax.inject.Inject

class TriviaRepository @Inject constructor(private val api:TriviaAPI) {
    private val dataOrException =
        DataOrException<ArrayList<
                QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllData():DataOrException<ArrayList<QuestionItem>,Boolean,Exception> {
        try{
            dataOrException.loading = true
            dataOrException.data = api.getAllData()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (exception:Exception) {
            dataOrException.exception = exception
            Log.d("EXCEPTION: ", exception.localizedMessage)
        }

        return dataOrException
    }
}