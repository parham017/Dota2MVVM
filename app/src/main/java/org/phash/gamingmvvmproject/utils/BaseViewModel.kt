package org.phash.gamingmvvmproject.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    var navigator: Navigator? = null

    var repo: T? = null

    val ldError = MutableLiveData<Event<String>>()
    val ldLoading = MutableLiveData<Event<Unit>>()
}