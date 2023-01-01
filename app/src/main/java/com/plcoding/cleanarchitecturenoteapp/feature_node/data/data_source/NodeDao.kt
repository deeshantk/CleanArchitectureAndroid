package com.plcoding.cleanarchitecturenoteapp.feature_node.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import kotlinx.coroutines.flow.Flow


@Dao
interface NodeDao {

    @Query("SELECT * FROM node")
    fun getNodes(): Flow<List<Node>>

    @Query("SELECT * FROM node WHERE id = :id")
    suspend fun getNodeById(id: Int): Node?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNode(node: Node)

    @Delete
    suspend fun deleteNode(node: Node)
}