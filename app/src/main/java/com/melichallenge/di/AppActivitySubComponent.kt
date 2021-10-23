package com.melichallenge.di

import com.melichallenge.di.items.ItemsComponent
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(
    subcomponents = [ItemsComponent::class]
)
class AppActivitySubComponent