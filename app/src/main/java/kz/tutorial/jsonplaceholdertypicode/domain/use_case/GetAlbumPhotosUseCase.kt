package kz.tutorial.jsonplaceholdertypicode.domain.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

interface GetAlbumPhotosUseCase {
    suspend fun invoke(albumId: Int): List<Photo>
}