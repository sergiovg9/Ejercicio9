package com.mexiti.catphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mexiti.catphotoapp.CatPhotoApplication
import com.mexiti.catphotoapp.data.CatPhotoRepository
import com.mexiti.catphotoapp.model.CatPhoto
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface CatUiState{
    data class Success(val photos: List<CatPhoto>) : CatUiState
    object Error: CatUiState
    object Loading: CatUiState
}
class CatViewModel(private val catPhotoRepository: CatPhotoRepository):ViewModel(){
    var catUiState:CatUiState  by mutableStateOf(CatUiState.Loading)
        private set

    init{
        getCatPhotos()
    }

   private  fun getCatPhotos(){
         viewModelScope.launch {
            catUiState = try {
                val listResult=catPhotoRepository.getCatPhotos()
                CatUiState.Success(listResult)
             } catch (e: IOException){
                 CatUiState.Error
             }

         }
    }

    companion object {
        val Factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application=(this[APPLICATION_KEY] as CatPhotoApplication)
                val catPhotoRepository=application.container.catPhotoRepository
                CatViewModel(catPhotoRepository=catPhotoRepository)
            }
        }
    }

}