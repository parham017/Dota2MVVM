package org.phash.gamingmvvmproject.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseRepoImpl {

    fun <T, P> getResponse(
        call: Call<T>, callback: RepoCallback<P>
    ): Flow<T> {
        val responseFlow = MutableSharedFlow<T>()

        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    val result = response.body()!!

                    runBlocking {
                        responseFlow.emit(result)
                    }
                } else {
                    val result = response.code().toString()

                    callback.onError(result)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                if (t.message?.contains(Message.NO_INTERNET) == true) {
                    val result = Message.network
                    val errorMessage = ApiError(t).message
                    Log.e("ErrorMessage", errorMessage)
                    callback.onError(result, true)
                } else {
                    val result = t.message.toString()
                    t.printStackTrace()
                    callback.onError(result)
                }
            }
        })

        return responseFlow.asSharedFlow()
    }
}