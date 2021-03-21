package com.dohwaji.infinitebuying

import android.app.Application
import android.content.Context

class InfiniteApplication: Application() {
    companion object {
        private lateinit var context: Context

        @JvmStatic
        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}