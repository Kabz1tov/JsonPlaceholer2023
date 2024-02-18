package kz.tutorial.jsonplaceholdertypicode.data.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumUseCase

class GetAlbumUseCaseImpl(private val repository: AlbumsRepository) : GetAlbumUseCase {
    override suspend fun invoke(albumId: Int): Album {
        return repository.getAlbum(albumId)
    }
}