package org.phash.gamingmvvmproject.hero.data.repo

import org.phash.gamingmvvmproject.hero.data.model.Attribute
import org.phash.gamingmvvmproject.hero.data.model.GetHeroes
import org.phash.gamingmvvmproject.hero.data.model.Hero


object HeroMapper {
    fun GetHeroes.toCommentList(): List<Hero> {
        val resultList: ArrayList<Hero> = arrayListOf()

        this.forEach {
            val attribute: Attribute = when (it.primary_attr) {
                "agi" -> Attribute.AGILITY
                "str" -> Attribute.STRANGE
                "int" -> Attribute.INTELLIGENCE
                else -> Attribute.ALL
            }
            val model = Hero(
                it.`1_pick`,
                it.`1_win`,
                it.`2_pick`,
                it.`2_win`,
                it.`3_pick`,
                it.`3_win`,
                it.`4_pick`,
                it.`4_win`,
                it.`5_pick`,
                it.`5_win`,
                it.`6_pick`,
                it.`6_win`,
                it.`7_pick`,
                it.`7_win`,
                it.`8_pick`,
                it.`8_win`,
                it.agi_gain,
                it.attack_point,
                it.attack_range,
                it.attack_rate,
                it.attack_type,
                it.base_agi,
                it.base_armor,
                it.base_attack_max,
                it.base_attack_min,
                it.base_attack_time,
                it.base_health,
                it.base_health_regen,
                it.base_int,
                it.base_mana,
                it.base_mana_regen,
                it.base_mr,
                it.base_str,
                it.cm_enabled,
                it.day_vision,
                it.icon,
                it.id,
                it.img,
                it.int_gain,
                it.legs.toString(),
                it.localized_name,
                it.move_speed,
                it.name,
                it.night_vision,
                attribute,
                it.pro_ban,
                it.pro_pick,
                it.pro_win,
                it.projectile_speed,
                it.pub_pick,
                it.pub_pick_trend,
                it.pub_win,
                it.pub_win_trend,
                it.roles,
                it.str_gain,
                it.turbo_picks,
                it.turbo_picks_trend,
                it.turbo_wins,
                it.turbo_wins_trend,
                it.turn_rate.toString()
            )
            resultList.add(model)
        }
        return resultList
    }
}
