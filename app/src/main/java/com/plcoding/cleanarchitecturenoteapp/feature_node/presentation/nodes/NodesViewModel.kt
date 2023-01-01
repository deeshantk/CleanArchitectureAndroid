package com.plcoding.cleanarchitecturenoteapp.feature_node.presentation.nodes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.model.Node
import com.plcoding.cleanarchitecturenoteapp.feature_node.domain.use_case.NodeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NodesViewModel @Inject constructor(
    private val nodeUseCases: NodeUseCases
): ViewModel() {
    private val _state = mutableStateOf(NodesState())
    val state: State<NodesState> = _state

    private var recentDeletedNode: Node? = null
    fun onEvent(event: NodesEvent) {
        when(event) {
            is NodesEvent.Order -> {

            }
            is NodesEvent.DeleteNode -> {
                viewModelScope.launch {
                    nodeUseCases.deleteNode(event.node)
                    recentDeletedNode = event.node
                }
            }
            is NodesEvent.RestoreNode -> {

            }
            is NodesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }
}