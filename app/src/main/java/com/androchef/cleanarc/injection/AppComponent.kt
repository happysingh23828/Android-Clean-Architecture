package com.androchef.cleanarc.injection

import android.app.Application
import com.androchef.cleanarc.injection.modules.*
import com.androchef.cleanarc.ui.movielist.MovieListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,CacheModule::class, DomainModule::class, RemoteModule::class, UIModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(movieListActivity: MovieListActivity)

}