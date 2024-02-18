package kz.tutorial.jsonplaceholdertypicode.data.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumPhotosUseCase

class GetAlbumPhotosUseCaseImpl(private val repo: AlbumsRepository) : GetAlbumPhotosUseCase {
    override suspend fun invoke(albumId: Int): List<Photo> {
        return repo.getAlbumPhotos(albumId)
    }
}