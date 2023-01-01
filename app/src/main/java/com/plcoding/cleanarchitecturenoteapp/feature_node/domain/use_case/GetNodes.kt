package com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.repository.NodeRepositoty
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util.NodeOrder
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNodes(
    private val repository: NodeRepositoty
) {
    operator fun invoke(
        nodeOrder: NodeOrder = NodeOrder.Date(OrderType.Descending)
    ): Flow<List<Node>> {
        return repository.getNodes().map { nodes ->
            when(nodeOrder.orderType) {
                is OrderType.Ascending -> {
                    when(nodeOrder) {
                        is NodeOrder.Tttle -> nodes.sortedBy { it.title.lowercase() }
                        is NodeOrder.Date -> nodes.sortedBy { it.timeStamp }
                        is NodeOrder.Color -> nodes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(nodeOrder) {
                        is NodeOrder.Tttle -> nodes.sortedByDescending { it.title.lowercase() }
                        is NodeOrder.Date -> nodes.sortedByDescending { it.timeStamp }
                        is NodeOrder.Color -> nodes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}