package com.melichallenge.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(
    subcomponents = []
)
class AppFragmentSubComponent