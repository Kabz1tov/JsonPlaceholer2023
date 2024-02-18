package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(albumId: Int): Album
    suspend fun getAlbumPhotos(albumId: Int): List<Photo>
}