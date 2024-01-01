package org.phash.gamingmvvmproject.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Client {

    companion object {
        lateinit var apiService: ApiService
        private var instance: Client? = null
        fun getInstance(): Client {
            if (instance == null) {
                instance = Client()
            }
            return instance!!
        }
    }

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttp =
            OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).addInterceptor(logging).build()
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder().client(okHttp).baseUrl(Url.baseDomain)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        apiService = retrofit.create(ApiService::class.java)

    }

    fun getApiService() = apiService
}