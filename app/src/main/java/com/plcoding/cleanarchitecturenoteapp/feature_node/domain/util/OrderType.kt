package com.plcoding.cleanarchitecturenoteapp.feature_node.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
