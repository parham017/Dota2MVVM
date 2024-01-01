package org.phash.gamingmvvmproject.utils

import com.google.gson.JsonParser
import retrofit2.HttpException

class ApiError constructor(error: Throwable) {
    var message = "An error occurred"

    init {
        if (error is HttpException) {
            val errorJsonString = error.response()?.errorBody()?.string()
            this.message = JsonParser().parse(errorJsonString).asJsonObject["message"].asString
        } else {
            this.message = error.message ?: this.message
        }
    }
}