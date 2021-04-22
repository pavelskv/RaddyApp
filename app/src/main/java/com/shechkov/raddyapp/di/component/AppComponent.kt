package com.shechkov.raddyapp.di.component

import android.app.Application
import com.shechkov.raddyapp.di.ActivityModuleBuilder
import com.shechkov.raddyapp.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.BindsInstance
import com.shechkov.raddyapp.di.module.AppModule
import com.shechkov.raddyapp.di.module.DataModule
import com.shechkov.raddyapp.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AppModule::class,
            DataModule::class,
            ActivityModuleBuilder::class,
            ViewModelModule::class
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}