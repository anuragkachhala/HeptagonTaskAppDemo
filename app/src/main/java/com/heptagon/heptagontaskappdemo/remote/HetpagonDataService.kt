package com.heptagon.heptagontaskappdemo.remote

import com.heptagon.heptagontaskappdemo.model.FormInfo
import retrofit2.Response
import retrofit2.http.GET

interface HetpagonDataService {

    @GET("hep-test.json")
    suspend fun getFormData() : Response<FormInfo>
}