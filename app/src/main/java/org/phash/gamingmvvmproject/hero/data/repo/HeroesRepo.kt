package org.phash.gamingmvvmproject.hero.data.repo

import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.utils.RepoCallback

interface HeroesRepo {
    suspend fun getHero(callback: RepoCallback<List<Hero>>)
}