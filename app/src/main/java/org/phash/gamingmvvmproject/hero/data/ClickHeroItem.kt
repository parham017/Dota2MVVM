package org.phash.gamingmvvmproject.hero.data

import org.phash.gamingmvvmproject.hero.data.model.Hero

interface ClickHeroItem {
    fun click(hero: Hero)
}