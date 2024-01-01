package org.phash.gamingmvvmproject.hero.data.repo

import org.phash.gamingmvvmproject.data.network.Client
import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.hero.data.repo.HeroMapper.toCommentList
import org.phash.gamingmvvmproject.utils.BaseRepoImpl
import org.phash.gamingmvvmproject.utils.RepoCallback

class HeroesApiImpl(private val client: Client) : BaseRepoImpl(), HeroesRepo {
    override suspend fun getHero(callback: RepoCallback<List<Hero>>) {
        val call = client.getApiService().getHero()
        getResponse(call, callback).collect {
            callback.onSuccessful(it.toCommentList())
        }
    }
}