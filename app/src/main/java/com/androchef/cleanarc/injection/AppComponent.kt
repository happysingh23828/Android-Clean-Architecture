package com.androchef.cleanarc.injection

import android.app.Application
import com.androchef.cleanarc.ui.MainActivity
import com.androchef.cleanarc.injection.modules.CacheModule
import com.androchef.cleanarc.injection.modules.DomainModule
import com.androchef.cleanarc.injection.modules.RemoteModule
import com.androchef.cleanarc.injection.modules.UIModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CacheModule::class, DomainModule::class, RemoteModule::class, UIModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}