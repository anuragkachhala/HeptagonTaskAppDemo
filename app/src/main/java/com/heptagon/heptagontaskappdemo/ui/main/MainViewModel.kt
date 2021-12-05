package com.heptagon.heptagontaskappdemo.ui.main

import androidx.lifecycle.*
import com.heptagon.heptagontaskappdemo.model.FormInfo
import com.heptagon.heptagontaskappdemo.repository.RemoteDataSourceRepository
import com.heptagon.heptagontaskappdemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val remoteDataSourceRepository: RemoteDataSourceRepository
) : ViewModel() {

    private val _formInfo: MutableLiveData<Resource<FormInfo>> = MutableLiveData(Resource.loading())

    val formInfo: LiveData<Resource<FormInfo>> = _formInfo

    fun getFromInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(remoteDataSourceRepository.getFormData())
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

  /*  fun getUsers() {
        viewModelScope.launch {
            _formInfo.value = remoteDataSourceRepository.getFormData()
        }
    }*/
}