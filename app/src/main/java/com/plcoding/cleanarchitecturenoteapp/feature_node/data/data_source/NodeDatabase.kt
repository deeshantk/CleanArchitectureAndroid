package com.plcoding.cleanarchitecturenoteapp.feature_node.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node

@Database(
    entities = [Node::class],
    version = 1
)
abstract class NodeDatabase: RoomDatabase() {
    abstract val nodeDao: NodeDao

    companion object{
        const val DATABASE_NAME = "NODES_DB"
    }
}