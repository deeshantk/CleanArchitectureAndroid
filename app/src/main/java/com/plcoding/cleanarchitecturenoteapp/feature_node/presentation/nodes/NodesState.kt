package com.plcoding.cleanarchitecturenoteapp.feature_node.presentation.nodes

import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util.NodeOrder
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util.OrderType

data class NodesState(
    val nodes: List<Node> = emptyList(),
    val nodesOrder: NodeOrder = NodeOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
