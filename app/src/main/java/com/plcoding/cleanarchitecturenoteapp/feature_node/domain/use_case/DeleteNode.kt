package com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.repository.NodeRepositoty


class DeleteNode(private val repository: NodeRepositoty) {
    suspend operator fun invoke(node: Node){
        repository.deleteNode(node)
    }
}