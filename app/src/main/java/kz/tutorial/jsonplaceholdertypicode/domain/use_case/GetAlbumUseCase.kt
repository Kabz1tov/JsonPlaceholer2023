package kz.tutorial.jsonplaceholdertypicode.domain.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album

interface GetAlbumUseCase {
    suspend fun invoke(albumId: Int): Album
}