package com.plcoding.cleanarchitecturenoteapp.feature_node.data.repositoty

import com.plcoding.cleanarchitecturenoteapp.feature_node.data.data_source.NodeDao
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.repository.NodeRepositoty
import kotlinx.coroutines.flow.Flow

class NodeRepositotyImpl(
    private val dao: NodeDao
): NodeRepositoty {

    override fun getNodes(): Flow<List<Node>> {
        return dao.getNodes()
    }

    override suspend fun getNodeById(id: Int): Node? {
        return dao.getNodeById(id)
    }

    override suspend fun insertNode(node: Node) {
        return dao.insertNode(node)
    }

    override suspend fun deleteNode(node: Node) {
        return dao.deleteNode(node)
    }
}