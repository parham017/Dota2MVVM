package org.phash.gamingmvvmproject.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.palette.graphics.Palette
import org.phash.gamingmvvmproject.R
import org.phash.gamingmvvmproject.data.network.Url

object Dota2Tools {

    @SuppressLint("DiscouragedApi")
    fun Context.getPortraitHeroImage(heroName: String): Int {
        var res = resources.getIdentifier(heroName, "drawable", packageName)
        if (res == 0) {
            res = R.drawable.npc_dota_hero_ursa
            Log.e("*****", heroName)
        }
        return res
    }

    fun getImageLink(link: String): String {
        return Url.baseDomain.substring(0, 25) + link.substring(1)
    }

    fun getBitmapFromImageView(imageView: ImageView): Bitmap {
        val bitmapDrawable = imageView.drawable as BitmapDrawable
        return bitmapDrawable.bitmap
    }

    fun Activity.drawableToBitmap(drawable: Drawable?): Bitmap {
        if (drawable is BitmapDrawable) {
            if (drawable.bitmap != null) {
                return drawable.bitmap
            }
        }
        val bitmap: Bitmap = if (drawable!!.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun bitmapToColor(bitmap: Bitmap, context: Context): Colorize {
        val tColor: Int
        val mColor: Int
        val palette = Palette.generate(bitmap)
        val swatch = palette.dominantSwatch
        tColor = swatch?.bodyTextColor ?: context.getColor(R.color.blue_primary)
        mColor = swatch?.rgb ?: context.getColor(R.color.blue_primary)
        return Colorize(tColor, mColor)
    }
}