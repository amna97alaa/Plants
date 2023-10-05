package com.amna.viewmodel.onboarding

import com.amna.viewmodel.base.BaseUiState
import com.amna.viewmodel.base.ErrorUiState

data class OnBoardingUiState(
    val loggedIn: Boolean = false,
    val error: ErrorUiState? = null,
) : BaseUiState