package com.akliars.kotlintodoapp.di

import android.content.Context
import androidx.room.Room
import com.akliars.kotlintodoapp.data.datasource.YapilacaklarDataSource
import com.akliars.kotlintodoapp.data.repo.YapilacaklarRepository
import com.akliars.kotlintodoapp.room.Veritabani
import com.akliars.kotlintodoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarRepository(yds:YapilacaklarDataSource) : YapilacaklarRepository{
        return YapilacaklarRepository(yds)
    }
    @Provides
    @Singleton
    fun provideDataSource(ydao:YapilacaklarDao) : YapilacaklarDataSource{
        return YapilacaklarDataSource(ydao)
    }
    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : YapilacaklarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"ali.sqlite")
            .createFromAsset("ali.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}