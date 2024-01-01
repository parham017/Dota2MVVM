package org.phash.gamingmvvmproject.hero

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import org.phash.gamingmvvmproject.R
import org.phash.gamingmvvmproject.databinding.FragmentHeroDetailBinding
import org.phash.gamingmvvmproject.hero.data.model.Attribute
import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.utils.Dota2Tools
import org.phash.gamingmvvmproject.utils.Dota2Tools.bitmapToColor


class HeroDetailFragment : Fragment() {
    private lateinit var b: FragmentHeroDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        b = FragmentHeroDetailBinding.inflate(layoutInflater, container, false)

        val model = arguments?.getParcelable<Hero>("HERO")
        if (model != null) {
            b.tvHeroName.text = model.localized_name
            b.tvBaseHealth.text = model.base_health.toString()
            b.tvHealthReg.text = " + " + model.base_health_regen.toString()
            b.tvBaseMana.text = model.base_mana.toString()
            b.tvManaReg.text = model.base_mana_regen.toString()
            b.tvAttack.text = model.attack_point.toString()
            b.tvAttackRate.text = model.attack_rate.toString()
            b.tvAttackDuration.text = model.base_attack_time.toString()
            b.tvArmor.text = model.base_armor.toString()
            b.tvStrengthValue.text = model.base_str.toString() + " + " + model.str_gain
            b.tvAgilityValue.text = model.base_agi.toString() + " + " + model.agi_gain
            b.tvIntelligenceValue.text = model.base_int.toString() + " + " + model.int_gain
            b.tvMovementSpeed.text = model.move_speed.toString()
            b.tvAttackDistance.text = model.day_vision.toString()
            b.tvHeroName.text = model.localized_name
            Picasso.get().load(Dota2Tools.getImageLink(model.img!!)).into(b.ivHeroImage)
            Picasso.get().load(Dota2Tools.getImageLink(model.img!!)).into(b.ivHeroBanner)
            Picasso.get().load(Dota2Tools.getImageLink(model.icon!!)).into(b.ivHeroIcon)
            b.tvAttributeType.text = model.primary_attr.toString()
            when (model.primary_attr) {
                Attribute.STRANGE -> b.tvAttributeType.backgroundTintList =
                    requireActivity().getColorStateList(R.color.red)

                Attribute.AGILITY -> b.tvAttributeType.backgroundTintList =
                    requireActivity().getColorStateList(R.color.green)

                Attribute.INTELLIGENCE -> b.tvAttributeType.backgroundTintList =
                    requireActivity().getColorStateList(R.color.blue)

                else -> {
                    b.tvAttributeType.backgroundTintList =
                        requireActivity().getColorStateList(R.color.gray)
                }
            }
        }
        val bitmap = Dota2Tools.getBitmapFromImageView(b.ivHeroImage)
        val colorize = bitmapToColor(bitmap, requireContext())
        changeTextColor(colorize.textColor)
        b.clRoot.setBackgroundColor(colorize.color)
        return b.root
    }

    private fun changeTextColor(color: Int) {

        b.tvHeroName.setTextColor(color)
        b.tvStrength.setTextColor(color)
        b.tvStrengthValue.setTextColor(color)
        b.tvAgility.setTextColor(color)
        b.tvAgilityValue.setTextColor(color)
        b.tvIntelligence.setTextColor(color)
        b.tvIntelligenceValue.setTextColor(color)
        /////////////////////////////////////////
        b.tvAttack.setTextColor(color)
        b.tvArmor.setTextColor(color)
        b.tvAttackDuration.setTextColor(color)
        b.tvAttackDistance.setTextColor(color)
        b.tvAttackRate.setTextColor(color)
        b.tvMovementSpeed.setTextColor(color)
        requireContext().apply {
            arrayOf(1)
            arrayOf(1)
            val states = arrayOf(
                intArrayOf(android.R.attr.state_enabled),
            )
            val colors = intArrayOf(
                color
            )
            val colorState = ColorStateList(states, colors)
            b.ivAttack.imageTintList = colorState
            b.ivAttackTime.imageTintList = colorState
            b.ivAttackRate.imageTintList = colorState
            b.ivMovementSpeed.imageTintList = colorState
            b.ivUnknown.imageTintList = colorState
            b.ivArmor.imageTintList = colorState
        }
    }

}