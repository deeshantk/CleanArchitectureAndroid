package com.plcoding.cleanarchitecturenoteapp.feature_node.presentation.nodes

import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util.NodeOrder

sealed class NodesEvent {
    data class Order(val nodeOrder: NodeOrder): NodesEvent()
    data class DeleteNode(val node: Node): NodesEvent()
    object RestoreNode: NodesEvent()
    object ToggleOrderSection: NodesEvent()
}
