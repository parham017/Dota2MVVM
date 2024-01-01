package org.phash.gamingmvvmproject.data.network


import org.phash.gamingmvvmproject.hero.data.model.GetHeroes
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(Url.hetHeroes)
    fun getHero(): Call<GetHeroes>

}