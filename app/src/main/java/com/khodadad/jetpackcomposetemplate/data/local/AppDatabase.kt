package com.khodadad.jetpackcomposetemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khodadad.jetpackcomposetemplate.data.dao.ExampleDao
import com.khodadad.jetpackcomposetemplate.data.entity.ExampleEntity
import com.khodadad.jetpackcomposetemplate.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [ExampleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getExampleDao(): ExampleDao

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}