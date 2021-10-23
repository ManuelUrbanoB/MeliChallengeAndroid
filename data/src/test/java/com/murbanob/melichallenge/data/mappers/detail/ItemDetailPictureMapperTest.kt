package com.murbanob.melichallenge.data.mappers.detail

import com.murbanob.melichallenge.data.api.entities.ItemDetailPicturesApi
import org.junit.Assert
import org.junit.jupiter.api.Test

internal class ItemDetailPictureMapperTest {
    @Test
    fun testConvertApiToDomain() {
        val itemPictureApi = ItemDetailPicturesApi("id", "url")
        val domainValue = ItemDetailPictureMapper.convertApiToDomain(itemPictureApi)
        Assert.assertEquals(domainValue.id, itemPictureApi.id)
        Assert.assertEquals(domainValue.url, itemPictureApi.secure_url)
    }
}