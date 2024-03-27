package com.khodadad.jetpackcomposetemplate.ui.splash

import androidx.lifecycle.ViewModel
import com.khodadad.jetpackcomposetemplate.data.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val exampleRepository: ExampleRepository) :
    ViewModel() {
    private val TAG = SplashViewModel::class.java.simpleName
}