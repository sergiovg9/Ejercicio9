package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.Rules.TestDispathcherRule
import com.mexiti.catphotoapp.viewmodel.CatUiState
import com.mexiti.catphotoapp.viewmodel.CatViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CatViewModelTest {
    @get: Rule
    val testDispatcher=TestDispathcherRule()
    @Test
    fun CatViewModel_getCatPhotos_verifyCatUiStateSuccess(){
        runTest{
            val catViewModel= CatViewModel(
                catPhotoRepository= FakeNetworkCatPhotoRepository()
            )
            assertEquals(CatUiState.Success(FakeDataSource.photoList),catViewModel.catUiState)
        }
    }
}