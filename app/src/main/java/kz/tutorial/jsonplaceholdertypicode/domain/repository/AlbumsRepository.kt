package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>

//    suspend fun getAlbumPhotos(albumId: Int): List<Photo>
}