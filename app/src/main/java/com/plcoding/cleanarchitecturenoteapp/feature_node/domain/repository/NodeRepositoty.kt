package com.plcoding.cleanarchitecturenoteapp.feature_node.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import kotlinx.coroutines.flow.Flow

interface NodeRepositoty {
    fun getNodes(): Flow<List<Node>>

    suspend fun getNodeById(id: Int): Node?

    suspend fun insertNode(node: Node)

    suspend fun deleteNode(node: Node)
}