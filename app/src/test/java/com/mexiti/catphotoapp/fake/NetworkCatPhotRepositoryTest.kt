package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.data.NetworkCatPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.testng.AssertJUnit.assertEquals

class NetworkCatPhotRepositoryTest {
    @Test
    fun networkCatPhotoRepository_getCatPhotos_verifyPhotoList(){
        runTest{
            val repository=NetworkCatPhotoRepository(
                catApiService = FakeCatApiService()
            )
            assertEquals(FakeDataSource.photoList,repository.getCatPhotos())
        }
    }
}