package ru.dezerom.tasktracker.core.ui.customScaffold

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object CustomScaffoldStateHolder {
    private val _state: MutableStateFlow<CustomScaffoldState> = MutableStateFlow(CustomScaffoldState())
    val state: StateFlow<CustomScaffoldState> = _state.asStateFlow()

    internal fun reduceState(reducer: CustomScaffoldState.() -> CustomScaffoldState) {
        _state.value = reducer(state.value)
    }
}