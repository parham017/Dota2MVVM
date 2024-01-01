package org.phash.gamingmvvmproject.hero

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.phash.gamingmvvmproject.App
import org.phash.gamingmvvmproject.R
import org.phash.gamingmvvmproject.databinding.FragmentHeroBinding
import org.phash.gamingmvvmproject.hero.adapter.UserAdapter
import org.phash.gamingmvvmproject.hero.data.ClickHeroItem
import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.hero.data.repo.HeroesApiImpl
import org.phash.gamingmvvmproject.hero.viewModel.HeroesViewModel

class HeroFragment : Fragment() {
    private lateinit var b: FragmentHeroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        b = FragmentHeroBinding.inflate(layoutInflater, container, false)
        init()

        return b.root
    }

    private fun init() {
        val vm = ViewModelProvider(requireActivity())[HeroesViewModel::class.java]
        val client = (requireActivity().application as App).client
        val apiRepo = HeroesApiImpl(client)
        vm.repo = apiRepo
        vm.getLdComment().observe(
            viewLifecycleOwner
        ) {
            b.rvHeroes.adapter = UserAdapter(it, object : ClickHeroItem {
                override fun click(hero: Hero) {
                    Log.e("*****", hero.attack_range.toString())
                    val bundle = Bundle().apply {
                        putParcelable("HERO", hero)
                    }
                    findNavController().navigate(
                        R.id.action_heroFragment_to_heroDetailFragment, bundle
                    )
                }
            })
        }
        if (vm.list.size == 0){
            vm.getHeroes()

        }
    }

}