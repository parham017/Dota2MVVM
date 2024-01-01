package org.phash.gamingmvvmproject.hero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.phash.gamingmvvmproject.R
import org.phash.gamingmvvmproject.databinding.ItemHeroBinding
import org.phash.gamingmvvmproject.hero.data.ClickHeroItem
import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.utils.DiffUtilCallback

class UserAdapter(private var list: List<Hero>, val clickHeroItem: ClickHeroItem) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val b: ItemHeroBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_hero, parent, false)
        return ViewHolder(b)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position])
        holder.click(list[position])
    }

    inner class ViewHolder(val b: ItemHeroBinding) : RecyclerView.ViewHolder(b.root) {
        fun setData(comment: Hero) {
            b.model = comment
        }

        fun click(hero: Hero) {
            b.root.setOnClickListener {
                clickHeroItem.click(hero)
            }
        }


    }

    private fun updateList(list: List<Hero>) {
        val diffCallback = DiffUtilCallback(this.list, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.list = list.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }
}