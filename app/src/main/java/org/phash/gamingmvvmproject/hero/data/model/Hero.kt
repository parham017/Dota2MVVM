package org.phash.gamingmvvmproject.hero.data.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import kotlinx.parcelize.Parcelize
import org.phash.gamingmvvmproject.R
import org.phash.gamingmvvmproject.utils.Dota2Tools

@Parcelize
data class Hero(
    val `1_pick`: Int,
    val `1_win`: Int,
    val `2_pick`: Int,
    val `2_win`: Int,
    val `3_pick`: Int,
    val `3_win`: Int,
    val `4_pick`: Int,
    val `4_win`: Int,
    val `5_pick`: Int,
    val `5_win`: Int,
    val `6_pick`: Int,
    val `6_win`: Int,
    val `7_pick`: Int,
    val `7_win`: Int,
    val `8_pick`: Int,
    val `8_win`: Int,
    val agi_gain: Double,
    val attack_point: Double,
    val attack_range: Int,
    val attack_rate: Double,
    val attack_type: String?,
    val base_agi: Int,
    val base_armor: Double,
    val base_attack_max: Int,
    val base_attack_min: Int,
    val base_attack_time: Int,
    val base_health: Int,
    val base_health_regen: Double,
    val base_int: Int,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_mr: Int,
    val base_str: Int,
    val cm_enabled: Boolean,
    val day_vision: Int,
    val icon: String?,
    val id: Int,
    val img: String?,
    val int_gain: Double,
    val legs: String?,
    val localized_name: String,
    val move_speed: Int,
    val name: String,
    val night_vision: Int,
    val primary_attr: Attribute,
    val pro_ban: Int,
    val pro_pick: Int,
    val pro_win: Int,
    val projectile_speed: Int,
    val pub_pick: Int,
    val pub_pick_trend: List<Int>?,
    val pub_win: Int,
    val pub_win_trend: List<Int>?,
    val roles: List<String>,
    val str_gain: Double,
    val turbo_picks: Int,
    val turbo_picks_trend: List<Int>?,
    val turbo_wins: Int,
    val turbo_wins_trend: List<Int>?,
    val turn_rate: String?
) : Parcelable {
    companion object {
        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun setImage(iv: ImageView, link: String?) {
            if (!link.isNullOrEmpty()) {
                Picasso.get().load(Dota2Tools.getImageLink(link))
                    .error(R.drawable.npc_dota_hero_axe).into(iv)
            }
        }

        @JvmStatic
        @BindingAdapter("android:setAttributeType", "android:setAttributeTypeIsEnable")
        fun setAttributeType(cv: CardView, attr: Attribute, boolean: Boolean) {
            if (boolean) {
                when (attr) {

                    Attribute.AGILITY -> cv.setCardBackgroundColor(cv.context.getColor(R.color.green))
                    Attribute.STRANGE -> cv.setCardBackgroundColor(cv.context.getColor(R.color.red))
                    Attribute.INTELLIGENCE -> cv.setCardBackgroundColor(cv.context.getColor(R.color.blue))
                    else -> {
                        cv.setCardBackgroundColor(cv.context.getColor(R.color.gray))
                    }
                }
            } else {
                cv.setCardBackgroundColor(cv.context.getColor(R.color.transparent))
                cv.cardElevation = 0f
            }

        }

    }

}

enum class Attribute {
    AGILITY, STRANGE, INTELLIGENCE, ALL
}
