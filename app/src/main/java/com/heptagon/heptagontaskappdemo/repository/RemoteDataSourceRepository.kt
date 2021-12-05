package com.heptagon.heptagontaskappdemo.repository

import com.heptagon.heptagontaskappdemo.remote.HetpagonDataService
import javax.inject.Inject


class RemoteDataSourceRepository @Inject constructor(
    private val heptagonDataService: HetpagonDataService
)  : BaseRemoteDataSourceRepo(){

    suspend fun getFormData() = getResult { heptagonDataService.getFormData()}
}