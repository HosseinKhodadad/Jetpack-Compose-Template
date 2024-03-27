package com.khodadad.jetpackcomposetemplate.data.remote

import com.khodadad.jetpackcomposetemplate.data.model.ExampleModel
import retrofit2.Response
import retrofit2.http.GET

interface AppApi {

    @GET("/api/v1/example")
    suspend fun getExampleResult(): Response<List<ExampleModel>>

}