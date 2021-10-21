package com.melichallenge.di

import com.melichallenge.BaseApplication
import com.melichallenge.di.items.ItemsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppActivitySubComponent::class,
        AppFragmentSubComponent::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplication): AppComponent
    }
}