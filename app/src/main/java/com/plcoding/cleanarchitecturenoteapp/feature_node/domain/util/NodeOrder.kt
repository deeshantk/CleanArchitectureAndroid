package com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util

sealed class NodeOrder(val orderType: OrderType) {
    class Tttle(orderType: OrderType): NodeOrder(orderType)
    class Date(orderType: OrderType): NodeOrder(orderType)
    class Color(orderType: OrderType): NodeOrder(orderType)
}
