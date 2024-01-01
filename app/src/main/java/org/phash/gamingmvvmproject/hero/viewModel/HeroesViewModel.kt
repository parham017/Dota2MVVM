package org.phash.gamingmvvmproject.hero.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.phash.gamingmvvmproject.hero.data.model.Hero
import org.phash.gamingmvvmproject.hero.data.repo.HeroesRepo
import org.phash.gamingmvvmproject.utils.BaseViewModel
import org.phash.gamingmvvmproject.utils.Event
import org.phash.gamingmvvmproject.utils.RepoCallback

class HeroesViewModel : BaseViewModel<HeroesRepo>() {

    private var ldComments: MutableLiveData<List<Hero>> = MutableLiveData()
    var list: MutableList<List<Hero>> = mutableListOf()

    fun getHeroes() {

        viewModelScope.launch(Dispatchers.IO) {
            repo?.getHero(object : RepoCallback<List<Hero>> {
                override fun onSuccessful(response: List<Hero>) {
                    list = response as MutableList<List<Hero>>
                    ldComments.postValue(response)
                }

                override fun onError(error: String, isNetwork: Boolean) {
                    ldError.postValue(Event(error))
                }
            })
        }
    }

    fun getLdComment(): LiveData<List<Hero>> {
        return ldComments
    }

}