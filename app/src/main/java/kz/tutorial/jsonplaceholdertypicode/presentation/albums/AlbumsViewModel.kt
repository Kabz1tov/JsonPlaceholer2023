package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album

class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _albumsLiveData: MutableLiveData<List<Album>> = MutableLiveData()
    val albumsLiveData: LiveData<List<Album>> = _albumsLiveData

    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch {
            val albums = getAlbumsUseCase.invoke()
            _albumsLiveData.postValue(albums)
        }
    }

}