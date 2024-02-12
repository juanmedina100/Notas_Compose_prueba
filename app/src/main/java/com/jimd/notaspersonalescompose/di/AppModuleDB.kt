package com.jimd.notaspersonalescompose.di

import android.content.Context
import androidx.room.Room
import com.jimd.notaspersonalescompose.data.NotasDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleDB {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(
        context,NotasDatabase::class.java,"notasDatanase"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db:NotasDatabase)= db.notasDao()


}