package com.kote.amphibian

import android.app.Application
import com.kote.amphibian.data.AppContainer
import com.kote.amphibian.data.DefaultAppContainer

class AmphibianApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}