package com.amna.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amna.entities.error.MovieException
import com.amna.entities.error.NetworkException
import com.amna.entities.error.NoInternetException
import com.amna.entities.error.NullResultException
import com.amna.entities.error.ValidationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : BaseUiState, UiEffect>(state: UiState) :
    ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<UiEffect>()
    val effect = _effect.asSharedFlow()

    fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccessWithData: (T) -> Unit = {},
        onSuccessWithoutData: () -> Unit = {},
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = execute()
                onSuccessWithData(result)
                onSuccessWithoutData()
            } catch (e: ValidationException) {
                onError(InvalidationErrorState(e.message.toString()))
            } catch (e: NullResultException) {
                onError(NullResultErrorState(e.message.toString()))
            } catch (e: NetworkException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: MovieException) {
                onError(ErrorUiState(e.message.toString()))
            } catch (e: NoInternetException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: Exception) {
                onError(ErrorUiState(e.message.toString()))
            }
        }
    }

    fun <T : Any> tryToExecutePaging(
        call: suspend () -> Flow<PagingData<T>>,
        onSuccess: suspend (PagingData<T>) -> Unit,
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = call().cachedIn(viewModelScope)
                result.collect { data ->
                    onSuccess(data)
                }
            } catch (e: NoInternetException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: NullResultException) {
                onError(NullResultErrorState(e.message.toString()))
            } catch (e: NetworkException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: MovieException) {
                onError(ErrorUiState(e.message.toString()))
            }
        }
    }

    protected fun sendUiEffect(uiEffect: UiEffect) {
        viewModelScope.launch(Dispatchers.IO) {
            _effect.emit(uiEffect)
        }
    }
}

interface BaseUiState

interface BaseUiEffect