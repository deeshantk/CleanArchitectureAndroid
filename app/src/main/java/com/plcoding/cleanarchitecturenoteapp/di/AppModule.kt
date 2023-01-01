package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_node.data.data_source.NodeDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_node.data.repositoty.NodeRepositotyImpl
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.repository.NodeRepositoty
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case.DeleteNode
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case.GetNodes
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case.NodeUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNodeDatabase(app: Application): NodeDatabase {
        return Room.databaseBuilder(
            app,
            NodeDatabase::class.java,
            NodeDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNodesRepository(db: NodeDatabase): NodeRepositoty {
        return NodeRepositotyImpl(db.nodeDao)
    }

    @Provides
    @Singleton
    fun provideNodesUseCases(repositoty: NodeRepositoty): NodeUseCases {
        return NodeUseCases(
            getNodes = GetNodes(repositoty),
            deleteNode = DeleteNode(repositoty)
        )
    }
}