package com.khodadad.jetpackcomposetemplate.ui.home

import androidx.lifecycle.ViewModel
import com.khodadad.jetpackcomposetemplate.data.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val exampleRepository: ExampleRepository) :
    ViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
}