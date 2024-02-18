package kz.tutorial.jsonplaceholdertypicode.presentation.album_photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumUseCase

class AlbumPhotosViewModel(
    private val albumId: Int,
    private val getAlbumUseCase: GetAlbumUseCase,
    private val getAlbumPhotosUseCase: GetAlbumPhotosUseCase
) : ViewModel() {

    private val _albumDetailsLiveData: MutableLiveData<Album> = MutableLiveData()
    val albumDetailsLiveData: LiveData<Album> = _albumDetailsLiveData

    private val _photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    val photosLiveData: LiveData<List<Photo>> = _photosLiveData

    init {
        getAlbumDetails()
        getAlbumPhotos()
    }

    private fun getAlbumDetails() {
        viewModelScope.launch {
            val albumDetails = getAlbumUseCase.invoke(albumId)
            _albumDetailsLiveData.value = albumDetails
        }
    }

    private fun getAlbumPhotos() {
        viewModelScope.launch {
            val albumPhotos = getAlbumPhotosUseCase.invoke(albumId)
            _photosLiveData.postValue(albumPhotos)
        }
    }
}