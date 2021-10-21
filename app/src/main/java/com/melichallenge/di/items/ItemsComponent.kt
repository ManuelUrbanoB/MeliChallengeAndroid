package com.melichallenge.di.items

import dagger.Subcomponent
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
@Subcomponent(modules = [ItemsModule::class])
interface ItemsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ItemsComponent
    }
}