package com.melichallenge.di.items

import com.murbanob.melichallenge.data.api.items.ItemApi
import com.murbanob.melichallenge.data.datasource.remote.ItemRemoteDataSource
import com.murbanob.melichallenge.data.datasource.remote.ItemRemoteDataSourceImpl
import com.murbanob.melichallenge.data.repository.items.ItemRepositoryImpl
import com.murbanob.melichallenge.domain.repository.items.ItemRepository
import com.murbanob.melichallenge.domain.usecase.items.GetItemDetailUseCase
import com.murbanob.melichallenge.domain.usecase.items.GetItemDetailUseCaseImpl
import com.murbanob.melichallenge.domain.usecase.items.GetSearchItemsUseCase
import com.murbanob.melichallenge.domain.usecase.items.GetSearchItemsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ItemsModule {

    companion object {
        @Provides
        fun provideDdpApi(retrofit: Retrofit): ItemApi {
            return retrofit.create(ItemApi::class.java)
        }

        @Provides
        fun provideDataSourceItem(itemApi: ItemApi): ItemRemoteDataSource =
            ItemRemoteDataSourceImpl(itemApi)

        @Provides
        fun provideRepositoryItem(itemRemoteDataSource: ItemRemoteDataSource): ItemRepository =
            ItemRepositoryImpl(itemRemoteDataSource)

        @Provides
        fun provideGetSearchItemsUseCase(itemRepository: ItemRepository): GetSearchItemsUseCase =
            GetSearchItemsUseCaseImpl(itemRepository)

        @Provides
        fun provideGetItemDetailUseCase(itemRepository: ItemRepository): GetItemDetailUseCase =
            GetItemDetailUseCaseImpl(itemRepository)

    }

}