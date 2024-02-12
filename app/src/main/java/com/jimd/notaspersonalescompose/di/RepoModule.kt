package com.jimd.notaspersonalescompose.di

import com.jimd.notaspersonalescompose.data.repositorio.NotasRepositorioImpl
import com.jimd.notaspersonalescompose.domain.NotasRepositorio
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun provideRepositorio(repositorioImpl: NotasRepositorioImpl):NotasRepositorio
}