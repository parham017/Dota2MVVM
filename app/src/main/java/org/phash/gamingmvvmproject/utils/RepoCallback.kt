package org.phash.gamingmvvmproject.utils

interface RepoCallback<T> {
    fun onSuccessful(response: T)
    fun onError(error: String , isNetwork : Boolean = false)
}
