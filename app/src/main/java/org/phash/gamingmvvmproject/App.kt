package org.phash.gamingmvvmproject

import android.app.Application
import org.phash.gamingmvvmproject.data.network.Client

class App : Application() {

    lateinit var client: Client

    override fun onCreate() {
        super.onCreate()
        client = Client.getInstance()
    }
}