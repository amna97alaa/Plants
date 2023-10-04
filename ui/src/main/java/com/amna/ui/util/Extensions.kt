package com.amna.ui.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import com.amna.viewmodel.base.BaseUiEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

fun CoroutineScope.launchCollectLatest(
    sharedFlow: SharedFlow<BaseUiEffect>,
    block: suspend CoroutineScope.(event: BaseUiEffect) -> Unit
) {
    launch {
        sharedFlow.collectLatest { event -> block(event) }
    }
}