package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetAlbumPhotosUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetAlbumUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetAlbumsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetPostPreviewCommentsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetPostUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetPostsUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetUserUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPostPreviewCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
    factory<GetPostUseCase> { GetPostUseCaseImpl(get()) }
    factory<GetPostPreviewCommentsUseCase> { GetPostPreviewCommentsUseCaseImpl(get()) }
    factory<GetUserUseCase> { GetUserUseCaseImpl(get()) }
    factory<GetAlbumsUseCase> { GetAlbumsUseCaseImpl(get()) }
    factory<GetAlbumUseCase> { GetAlbumUseCaseImpl(get()) }
    factory<GetAlbumPhotosUseCase> { GetAlbumPhotosUseCaseImpl(get()) }
}