package com.lorenzofonseca.gitpub

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.lorenzofonseca.gitpub.di.serviceModules
import com.lorenzofonseca.gitpub.di.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GitPubApplication : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GitPubApplication)
            modules(viewModules, serviceModules)
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this@GitPubApplication)
            .crossfade(true)
            .build()
    }
}