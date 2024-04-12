package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.data.CatPhotoRepository
import com.mexiti.catphotoapp.model.CatPhoto

class FakeNetworkCatPhotoRepository:CatPhotoRepository {
    override suspend fun getCatPhotos(): List<CatPhoto> {
        return FakeDataSource.photoList
    }
}