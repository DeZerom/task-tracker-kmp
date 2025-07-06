package ru.dezerom.tasktracker.core.ui.decompose

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

interface IBaseComponent<State, Event, SideEffect> {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun consumeEvent(event: Event)
}

abstract class BaseComponent<State, Event, SideEffect>(
    componentContext: ComponentContext
): IBaseComponent<State, Event, SideEffect>, ComponentContext by componentContext {
    protected val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _state = MutableStateFlow(initState())
    override val state = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SideEffect>()
    override val sideEffect = _sideEffect.asSharedFlow()

    abstract fun initState(): State

    protected abstract suspend fun handleEvent(event: Event)

    override fun consumeEvent(event: Event) {
        coroutineScope.launch {
            handleEvent(event)
        }
    }

    protected fun setState(state: State) {
        _state.value = state
    }

    protected fun reduceState(reducer: State.() -> State) {
        setState(reducer(state.value))
    }
}