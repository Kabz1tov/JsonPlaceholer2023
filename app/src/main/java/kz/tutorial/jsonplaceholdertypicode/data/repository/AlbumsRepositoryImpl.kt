package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {

    override suspend fun getAlbums(): List<Album> {
        return mainApi.getAlbums()
    }

/*    override suspend fun getAlbumPhotos(albumId: Int): List<Photo> {
        return mainApi.getAlbumPhotos(albumId)
    }*/
}