package com.khodadad.jetpackcomposetemplate.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khodadad.jetpackcomposetemplate.data.model.ExampleModel
import com.khodadad.jetpackcomposetemplate.data.model.Resource
import com.khodadad.jetpackcomposetemplate.data.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val exampleRepository: ExampleRepository) :
    ViewModel() {

    private val _data: MutableLiveData<Resource<List<ExampleModel>>> = MutableLiveData()
    val data: LiveData<Resource<List<ExampleModel>>>
        get() = _data

    fun fetchData() {
        viewModelScope.launch {
            _data.value = Resource.Loading
            _data.value = exampleRepository.fetchData()
        }
    }

    fun updateData(exampleModel: ExampleModel) {
        viewModelScope.launch {
            exampleRepository.updateData(exampleModel)
        }
    }

    fun deleteData(exampleModel: ExampleModel) {
        viewModelScope.launch {
            exampleRepository.deleteData(exampleModel)
        }
    }
}