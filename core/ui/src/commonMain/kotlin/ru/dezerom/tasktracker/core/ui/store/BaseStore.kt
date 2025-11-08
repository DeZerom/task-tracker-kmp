package ru.dezerom.tasktracker.core.ui.store

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseStore<Event, State, SideEffect> : InstanceKeeper.Instance {
    protected val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _state = MutableStateFlow(initState())
    val state = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    val currentState get() = _state.value

    abstract fun initState(): State

    protected abstract suspend fun handleEvent(event: Event)

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }

    fun consumeEvent(event: Event) {
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

    protected fun setSideEffect(effect: SideEffect) {
        coroutineScope.launch { _sideEffect.emit(effect) }
    }
}