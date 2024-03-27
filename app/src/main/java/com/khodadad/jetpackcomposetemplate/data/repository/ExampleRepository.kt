package com.khodadad.jetpackcomposetemplate.data.repository

import com.khodadad.jetpackcomposetemplate.data.dao.ExampleDao
import com.khodadad.jetpackcomposetemplate.data.remote.AppApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepository @Inject constructor(
    private val appApi: AppApi,
    private val exampleDao: ExampleDao
)