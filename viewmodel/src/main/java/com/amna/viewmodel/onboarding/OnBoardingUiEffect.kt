package com.amna.viewmodel.onboarding

import com.amna.viewmodel.base.BaseUiEffect

sealed interface OnBoardingUiEffect : BaseUiEffect {
    data object NavigateToHomeScreen : OnBoardingUiEffect
}