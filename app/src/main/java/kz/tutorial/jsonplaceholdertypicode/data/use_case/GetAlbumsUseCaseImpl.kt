package kz.tutorial.jsonplaceholdertypicode.data.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repository.AlbumsRepository

class GetAlbumsUseCaseImpl(private val albumsRepository: AlbumsRepository) : GetAlbumsUseCase {
    override suspend fun invoke(): List<Album> {
        return albumsRepository.getAlbums()
    }
}