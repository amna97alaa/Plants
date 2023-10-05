package com.amna.viewmodel.onboarding

import androidx.lifecycle.viewModelScope
import com.amna.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(

) : BaseViewModel<OnBoardingUiState, OnBoardingUiEffect>(OnBoardingUiState()),
    OnBoardingInteraction {
    override fun onClickLetsStart() {
        viewModelScope.launch {
            sendUiEffect(OnBoardingUiEffect.NavigateToHomeScreen)
        }
    }
}